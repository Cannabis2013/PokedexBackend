package kea.pokedexbackend.dbservices.Measurements.MySqlProvider.count;

import kea.pokedexbackend.db.connectionbuilders.ConnectionProvider;
import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.db.connectionbuilders.IConnectionBuilder;
import kea.pokedexbackend.db.measurements.count.IDbPokemonCounter;
import kea.pokedexbackend.models.Measurements.count.CountDetails;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DbPokemonCounter extends ConnectionProvider implements IDbPokemonCounter {
    public DbPokemonCounter(IConnectionBuilder builder) {
        super(builder);
    }

    @Override
    public List<CountDetails> count() throws DbConnectionException {
        try {
            var dbResult = getConnection()
                    .createStatement().executeQuery("""
                SELECT COUNT(name) as count, primary_type as type  
                from pokemon p 
                GROUP BY primary_type
                ORDER BY count DESC;
            """);
            return ResultConverter.Convert(dbResult);

        } catch (SQLException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

package kea.pokedexbackend.Dbservices.Measurements.MySqlProvider.count;

import kea.pokedexbackend.Dbservices.Connectionbuilders.MysqlConnection;
import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;
import kea.pokedexbackend.Db.measurements.count.IDbPokemonCounter;
import kea.pokedexbackend.models.Measurements.count.CountDetails;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MySqlPokemonCount implements IDbPokemonCounter {
    @Override
    public List<CountDetails> count() throws DbConnectionException {
        try {
            var dbResult = MysqlConnection.get()
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

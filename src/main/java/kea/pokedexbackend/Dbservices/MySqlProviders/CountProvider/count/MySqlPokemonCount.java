package kea.pokedexbackend.Dbservices.MySqlProviders.CountProvider.count;

import kea.pokedexbackend.Db.Connector.IDbConnector;
import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;
import kea.pokedexbackend.Db.measurements.count.IDbPokemonCounter;
import kea.pokedexbackend.models.Measurements.count.CountDetails;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MySqlPokemonCount implements IDbPokemonCounter {
    public MySqlPokemonCount(IDbConnector dbConnector) {
        _dbConnector = dbConnector;
    }

    @Override
    public List<CountDetails> count() throws DbConnectionException {
        try {
            var dbResult = _dbConnector.get()
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

    private final IDbConnector _dbConnector;
}

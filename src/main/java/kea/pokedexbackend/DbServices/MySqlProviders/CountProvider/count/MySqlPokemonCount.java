package kea.pokedexbackend.DbServices.MySqlProviders.CountProvider.count;

import kea.pokedexbackend.Contracts.Db.Connector.IDbConnection;
import kea.pokedexbackend.Contracts.Db.measurements.count.IDbPokemonCounter;
import kea.pokedexbackend.models.Measurements.count.CountDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySqlPokemonCount implements IDbPokemonCounter {
    public MySqlPokemonCount(IDbConnection dbConnector) {
        _dbConnection = dbConnector;
    }

    @Override
    public List<CountDetails> count() {
        var dbResult = _dbConnection.performQuery(query());
        var counts = ResultConverter.Convert(dbResult);
        return counts;
    }

    private String query(){
        return String.format("""
                SELECT COUNT(name) %s, primary_type %s  
                from pokemon
                GROUP BY primary_type
                ORDER BY count DESC;
            """, _columnCountTitle,_columnTypeTitle);
    }

    // Column titles
    private final String _columnCountTitle = "count";
    private final String _columnTypeTitle = "type";
    // Services
    private final IDbConnection _dbConnection;
}

package kea.pokedexbackend.Services.MySqlProviders.CountProvider.average;

import kea.pokedexbackend.Contracts.Connector.IDbConnection;
import kea.pokedexbackend.Contracts.measurements.average.IDbAverageGrassHP;
import org.springframework.stereotype.Service;

@Service
public class MySqlAverageGrassHP implements IDbAverageGrassHP {
    public MySqlAverageGrassHP(IDbConnection dbConnector) {
        _dbConnector = dbConnector;
    }

    @Override
    public double get() {
        var result = _dbConnector.performQuery(query());
        try {
            return result.next() ? result.getDouble(_columnTitle) : _errVal;
        } catch (Exception e){
            e.printStackTrace();
        }
        return _errVal;
    }

    private String query(){
        return String.format("""
                SELECT  AVG(hp) %s
                FROM pokemon p 
                WHERE p.primary_type = 'Grass';
            """,_columnTitle);
    }

    private final double _errVal = -1;
    private final String _columnTitle = "avg";
    private final IDbConnection _dbConnector;
}

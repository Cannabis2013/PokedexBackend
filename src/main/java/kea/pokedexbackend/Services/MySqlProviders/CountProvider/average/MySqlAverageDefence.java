package kea.pokedexbackend.Services.MySqlProviders.CountProvider.average;

import kea.pokedexbackend.Contracts.Connector.IDbConnection;
import kea.pokedexbackend.Contracts.measurements.average.IDbAverageDefence;
import org.springframework.stereotype.Service;

@Service
public class MySqlAverageDefence implements IDbAverageDefence {
    public MySqlAverageDefence(IDbConnection dbConnector) {
        _dbConnector = dbConnector;
    }

    @Override
    public double get(){
        try {
            var dbResult = _dbConnector.performQuery(query());
            return dbResult.next() ? dbResult.getDouble(_columnTitle) : _errVal;
        } catch (Exception e){
            e.printStackTrace();
        }
        return _errVal;
    }

    private String query(){
        return String.format("SELECT AVG(defence) %s from pokemon;",_columnTitle);
    }

    private final double _errVal = -1;
    private final String _columnTitle = "avg";

    private final IDbConnection _dbConnector;
}

package kea.pokedexbackend.Services.MySqlProviders.CountProvider.count;

import kea.pokedexbackend.Contracts.Connector.IDbConnection;
import kea.pokedexbackend.Contracts.measurements.count.IDbAboveAverageHP;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class MySqlAboveAverageHP implements IDbAboveAverageHP {
    public MySqlAboveAverageHP(IDbConnection dbConnector) {
        _dbConnection = dbConnector;
    }

    @Override
    public int count() {
        var dbResult = _dbConnection.performQuery(query());
        try {
            return dbResult.next() ? dbResult.getInt(_columnTitle) : _errVal;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _errVal;
    }

    private String query(){
        return String.format("""
                SELECT COUNT(*) AS %s 
                FROM pokemon p
                WHERE hp > (SELECT AVG(hp) FROM pokemon p);
            """,_columnTitle);
    }

    private final int _errVal = -1;
    private final String _columnTitle = "count";
    // Services
    private final IDbConnection _dbConnection;
}

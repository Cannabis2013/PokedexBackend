package kea.pokedexbackend.Services.MySqlProviders.CountProvider.average;

import kea.pokedexbackend.Contracts.Connector.IDbConnection;
import kea.pokedexbackend.Contracts.measurements.average.IDbFastestAvgType;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class MySqlFastestPrimaryType implements IDbFastestAvgType {
    public MySqlFastestPrimaryType(IDbConnection dbConnector) {
        _dbConnection = dbConnector;
    }

    @Override
    public String get() {
        var dbResult = _dbConnection.performQuery(query());
        try {
            return dbResult.next() ? dbResult.getString(_columnTypeTitle) : _errMsg;
        } catch (SQLException e) {
            e.printStackTrace();
            return _errMsg;
        }
    }

    private String query(){
        return String.format("""
                    SELECT primary_type %s
                    FROM pokemon p
                    GROUP BY primary_type
                    ORDER BY AVG(speed) DESC
                    LIMIT 1;
                """,_columnTypeTitle);
    }

    // Column titles

    private final String _errMsg = "Error";
    private final String _columnTypeTitle = "type";
    // Services
    private final IDbConnection _dbConnection;
}

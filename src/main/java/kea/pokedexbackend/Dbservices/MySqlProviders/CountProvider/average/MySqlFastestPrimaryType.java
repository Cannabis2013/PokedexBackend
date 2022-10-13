package kea.pokedexbackend.Dbservices.MySqlProviders.CountProvider.average;

import kea.pokedexbackend.Db.Connector.IDbConnector;
import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;
import kea.pokedexbackend.Db.measurements.average.IDbFastestAvgType;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class MySqlFastestPrimaryType implements IDbFastestAvgType {
    public MySqlFastestPrimaryType(IDbConnector dbConnector) {
        _dbConnector = dbConnector;
    }

    @Override
    public String get() throws DbConnectionException {
        try {
            var result = _dbConnector.get().createStatement().executeQuery(query());
            if(result.next())
                return result.getString("type");
        } catch (SQLException e) {
            return "";
        }
        return "";
    }

    private String query(){
        return """
                SELECT AVG(speed) as avg, primary_type type 
                FROM pokemon p
                GROUP BY primary_type
                ORDER BY avg DESC
                LIMIT 1;
            """;
    }

    private final IDbConnector _dbConnector;
}

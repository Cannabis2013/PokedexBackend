package kea.pokedexbackend.Dbservices.MySqlProviders.CountProvider.count;

import kea.pokedexbackend.Db.Connector.IDbConnection;
import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;
import kea.pokedexbackend.Db.measurements.count.IDbAboveAverageHP;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MySqlAboveAverageHP implements IDbAboveAverageHP {
    public MySqlAboveAverageHP(IDbConnection dbConnector) {
        _dbConnector = dbConnector;
    }

    @Override
    public int count() throws DbConnectionException {
        try {
            var dbResult = _dbConnector.get()
                    .createStatement().executeQuery("""
                SELECT COUNT(*) AS count 
                FROM pokemon p
                WHERE hp > (SELECT AVG(hp) FROM pokemon p);
            """);
            if(dbResult.next())
                return dbResult.getInt("count");
        } catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
        return -1;
    }

    private final IDbConnection _dbConnector;
}

package kea.pokedexbackend.Dbservices.Measurements.MySqlProvider.count;

import kea.pokedexbackend.Db.Connector.IDbConnector;
import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;
import kea.pokedexbackend.Db.measurements.count.IDbAboveAverageHP;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MySqlAboveAverageHP implements IDbAboveAverageHP {
    public MySqlAboveAverageHP(IDbConnector dbConnector) {
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

    private final IDbConnector _dbConnector;
}

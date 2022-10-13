package kea.pokedexbackend.Dbservices.MySqlProviders.CountProvider.average;

import kea.pokedexbackend.Db.Connector.IDbConnection;
import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;
import kea.pokedexbackend.Db.measurements.average.IDbAverageGrassHP;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySqlAverageGrassHP implements IDbAverageGrassHP {
    public MySqlAverageGrassHP(IDbConnection dbConnector) {
        _dbConnector = dbConnector;
    }

    @Override
    public double get() throws DbConnectionException {
        try {
            ResultSet dbResult = _dbConnector.get()
                    .createStatement().executeQuery("""
                SELECT  AVG(hp) AS average FROM pokemon p WHERE p.primary_type = 'Grass';
            """);
            if(dbResult.next())
                return dbResult.getDouble("average");
        } catch (SQLException e){
            return -1;
        }
        return -1;
    }

    private final IDbConnection _dbConnector;
}

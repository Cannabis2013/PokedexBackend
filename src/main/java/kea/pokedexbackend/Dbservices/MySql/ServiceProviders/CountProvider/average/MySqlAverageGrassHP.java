package kea.pokedexbackend.Dbservices.MySql.ServiceProviders.CountProvider.average;

import kea.pokedexbackend.Db.Connector.IDbConnector;
import kea.pokedexbackend.Dbservices.MySql.Connectors.DbConnectionException;
import kea.pokedexbackend.Db.measurements.average.IDbAverageGrassHP;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySqlAverageGrassHP implements IDbAverageGrassHP {
    public MySqlAverageGrassHP(IDbConnector dbConnector) {
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

    private final IDbConnector _dbConnector;
}

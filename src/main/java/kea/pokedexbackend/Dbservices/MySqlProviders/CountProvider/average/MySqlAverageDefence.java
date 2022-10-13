package kea.pokedexbackend.Dbservices.MySqlProviders.CountProvider.average;

import kea.pokedexbackend.Db.Connector.IDbConnector;
import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;
import kea.pokedexbackend.Db.measurements.average.IDbAverageDefence;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySqlAverageDefence implements IDbAverageDefence {
    public MySqlAverageDefence(IDbConnector dbConnector) {
        _dbConnector = dbConnector;
    }

    @Override
    public double get() throws DbConnectionException {
        try {
            ResultSet dbResult = _dbConnector.get()
                    .createStatement().executeQuery("""
                SELECT AVG(defence) as average from pokemon p;
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

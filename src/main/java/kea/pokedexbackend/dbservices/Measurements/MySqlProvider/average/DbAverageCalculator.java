package kea.pokedexbackend.dbservices.Measurements.MySqlProvider.average;

import kea.pokedexbackend.db.connectionbuilders.ConnectionProvider;
import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.db.connectionbuilders.IConnectionBuilder;
import kea.pokedexbackend.db.measurements.average.IDbAverageDefence;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DbAverageCalculator
        extends ConnectionProvider
        implements IDbAverageDefence {
    public DbAverageCalculator(IConnectionBuilder builder) {
        super(builder);
    }

    @Override
    public double get() throws DbConnectionException {
        try {
            ResultSet dbResult = getConnection()
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

    public double averageGrassHP() throws DbConnectionException {
        try {
            ResultSet dbResult = getConnection()
                    .createStatement().executeQuery("""
                SELECT  AVG(hp) FROM pokemon p WHERE p.primary_type = 'Grass';
            """);
            if(dbResult.next())
                return dbResult.getDouble("average");
        } catch (SQLException e){
            return -1;
        }
        return -1;
    }
}

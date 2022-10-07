package kea.pokedexbackend.dbservices.Measurements.MySqlProvider.average;

import kea.pokedexbackend.db.connectionbuilders.ConnectionProvider;
import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.db.connectionbuilders.IConnectionBuilder;
import kea.pokedexbackend.db.measurements.average.IDbFastestAvgType;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DbFastestPrimaryType extends ConnectionProvider implements IDbFastestAvgType {

    protected DbFastestPrimaryType(IConnectionBuilder builder) {
        super(builder);
    }

    @Override
    public String get() throws DbConnectionException {
        try {
            var result = getConnection().createStatement().executeQuery("""
                SELECT AVG(speed) as avg, primary_type as type FROM pokemon p
                GROUP BY primary_type
                ORDER BY avg DESC
                LIMIT 1;
            """);
            if(result.next())
                return result.getString("type");
        } catch (SQLException e) {
            return "";
        }
        return "";
    }
}

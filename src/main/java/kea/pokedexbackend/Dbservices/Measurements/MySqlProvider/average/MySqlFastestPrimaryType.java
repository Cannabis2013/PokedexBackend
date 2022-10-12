package kea.pokedexbackend.Dbservices.Measurements.MySqlProvider.average;

import kea.pokedexbackend.Dbservices.Connectionbuilders.MysqlConnection;
import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;
import kea.pokedexbackend.Db.measurements.average.IDbFastestAvgType;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MySqlFastestPrimaryType implements IDbFastestAvgType {
    @Override
    public String get() throws DbConnectionException {
        try {
            var result = MysqlConnection.get().createStatement().executeQuery("""
                SELECT AVG(speed) as avg, primary_type type 
                FROM pokemon p
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

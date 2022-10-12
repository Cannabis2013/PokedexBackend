package kea.pokedexbackend.Dbservices.Measurements.MySqlProvider.average;

import kea.pokedexbackend.Dbservices.Connectionbuilders.MysqlConnection;
import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;
import kea.pokedexbackend.Db.measurements.average.IDbAverageDefence;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySqlAverageDefence implements IDbAverageDefence {
    @Override
    public double get() throws DbConnectionException {
        try {
            ResultSet dbResult = MysqlConnection.get()
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
}

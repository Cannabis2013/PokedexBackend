package kea.pokedexbackend.dbservices.Measurements.MySqlProvider.count;

import kea.pokedexbackend.db.connectionbuilders.ConnectionProvider;
import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.db.connectionbuilders.IConnectionBuilder;
import kea.pokedexbackend.db.measurements.count.IDbAboveAverageHP;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DbAboveAverageHP extends ConnectionProvider implements IDbAboveAverageHP {
    public DbAboveAverageHP(IConnectionBuilder builder) {
        super(builder);
    }

    @Override
    public int count() throws DbConnectionException {
        try {
            var dbResult = getConnection()
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
}

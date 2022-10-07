package kea.pokedexbackend.dbservices.Measurements.MySqlProvider.average;

import kea.pokedexbackend.db.connectionbuilders.ConnectionProvider;
import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.db.connectionbuilders.IConnectionBuilder;
import kea.pokedexbackend.db.measurements.average.IDbAverageGrassHP;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DbAverageGrassHP extends ConnectionProvider implements IDbAverageGrassHP {

    protected DbAverageGrassHP(IConnectionBuilder builder) {
        super(builder);
    }

    @Override
    public double get() throws DbConnectionException {
        try {
            ResultSet dbResult = getConnection()
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
}

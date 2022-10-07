package kea.pokedexbackend.dbservices.ConnectionBuilders;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.db.connectionbuilders.IConnectionBuilder;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class DbConnectionBuilder implements IConnectionBuilder {
    @Override
    public Connection build() throws DbConnectionException {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokedex",
                    "mh","xrpuofni");
        } catch (SQLException e){
            throw new DbConnectionException(e);
        }
        return con;
    }
}

package kea.pokedexbackend.Dbservices.Connectionbuilders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    public static Connection get() throws DbConnectionException {
        Connection con;
        try {
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e){
            throw new DbConnectionException(e);
        }
        return con;
    }

    private static final String URL = "jdbc:mysql://localhost:3306/pokedex";
    private static final String USERNAME = "mh";
    private static final String PASSWORD = "xrpuofni";
}

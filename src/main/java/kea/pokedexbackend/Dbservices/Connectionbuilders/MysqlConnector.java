package kea.pokedexbackend.Dbservices.Connectionbuilders;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class MysqlConnector implements kea.pokedexbackend.Db.Connector.IDbConnector {
    public MysqlConnector(Environment env) {
        _env = env;
    }

    @Override
    public Connection get() throws DbConnectionException {
        var url = _env.getProperty("spring.datasource.url");
        var username = _env.getProperty("spring.datasource.username");
        var password = _env.getProperty("spring.datasource.password");
        Connection con;
        try {
            con = DriverManager.getConnection(url,username,password);
        } catch (SQLException e){
            throw new DbConnectionException(e);
        }
        return con;
    }

    private final Environment _env;

}

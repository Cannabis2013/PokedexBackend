package kea.pokedexbackend.Dbservices.MySql.Connectors;

import kea.pokedexbackend.Db.Connector.IDbConnector;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class MySqlConnector implements IDbConnector {
    public MySqlConnector(Environment env) {
        _env = env;
    }

    @Override
    public Connection get() throws DbConnectionException {
        var url = _env.getProperty(_urlProperty);
        var username = _env.getProperty(_usernameProperty);
        var password = _env.getProperty(_passwordProperty);
        Connection con;
        try {
            con = DriverManager.getConnection(url,username,password);
        } catch (SQLException e){
            throw new DbConnectionException(e);
        }
        return con;
    }

    private final String _urlProperty = "spring.datasource.url";
    private final String _usernameProperty = "spring.datasource.username";
    private final String _passwordProperty = "pring.datasource.password";

    private final Environment _env;

}

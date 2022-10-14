package kea.pokedexbackend.DbServices.Connectors;

import kea.pokedexbackend.Contracts.Db.Connector.IDbConnection;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DefaultDbConnection implements IDbConnection {
    public DefaultDbConnection(Environment env) {
        _env = env;
    }

    @Override
    public ResultSet performQuery(String query) {
        Connection con;
        try {
            return connection().prepareStatement(query).executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean performStatement(String statement) {
        Connection con;
        try {
            connection().prepareStatement(statement).execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Connection connection() throws DbConnectionException {
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
    private final String _passwordProperty = "spring.datasource.password";



    private final Environment _env;

}

package kea.pokedexbackend.dbservices.ConnectionBuilders;

import kea.pokedexbackend.db.connectionbuilders.IConnectionBuilder;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnectionBuilder2 implements IConnectionBuilder {
    @Override
    public Connection build() {
        Context ctx;
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        try {
            var bindings = ctx.listBindings("");
            System.out.println(bindings);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        DataSource ds;
        try {
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDb");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        Connection con;
        try {
            con = ds.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return con;
    }
}

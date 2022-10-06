package kea.pokedexbackend.db.connectionbuilders;

import java.sql.Connection;

public class ConnectionProvider {
    protected ConnectionProvider(IConnectionBuilder builder) {
        _builder = builder;
    }

    protected Connection getConnection() throws DbConnectionException {
        return _builder.build();
    }

    private final IConnectionBuilder _builder;
}

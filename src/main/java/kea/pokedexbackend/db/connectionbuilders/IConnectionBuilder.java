package kea.pokedexbackend.db.connectionbuilders;

import java.sql.Connection;

public interface IConnectionBuilder {
    Connection build() throws DbConnectionException;
}

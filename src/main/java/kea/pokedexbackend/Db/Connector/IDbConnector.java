package kea.pokedexbackend.Db.Connector;

import kea.pokedexbackend.Dbservices.MySql.Connectors.DbConnectionException;

import java.sql.Connection;

public interface IDbConnector {
    Connection get() throws DbConnectionException;
}

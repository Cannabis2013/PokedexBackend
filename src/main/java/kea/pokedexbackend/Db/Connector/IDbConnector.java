package kea.pokedexbackend.Db.Connector;

import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;

import java.sql.Connection;

public interface IDbConnector {
    Connection get() throws DbConnectionException;
}

package kea.pokedexbackend.Contracts.Connector;

import java.sql.ResultSet;

public interface IDbConnection {
    ResultSet performQuery(String query);
    boolean performStatement(String statement);
}

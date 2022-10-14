package kea.pokedexbackend.Contracts.Db.Connector;

import java.sql.ResultSet;

public interface IDbConnection {
    ResultSet performQuery(String query);
    boolean performStatement(String statement);
}

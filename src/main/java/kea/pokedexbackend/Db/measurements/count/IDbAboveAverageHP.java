package kea.pokedexbackend.Db.measurements.count;

import kea.pokedexbackend.Dbservices.MySql.Connectors.DbConnectionException;

public interface IDbAboveAverageHP {
    int count() throws DbConnectionException;
}

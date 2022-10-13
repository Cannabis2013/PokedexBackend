package kea.pokedexbackend.Db.measurements.count;

import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;

public interface IDbAboveAverageHP {
    int count() throws DbConnectionException;
}

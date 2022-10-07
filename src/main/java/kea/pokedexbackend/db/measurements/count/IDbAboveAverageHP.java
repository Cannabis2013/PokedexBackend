package kea.pokedexbackend.db.measurements.count;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;

public interface IDbAboveAverageHP {
    int count() throws DbConnectionException;
}

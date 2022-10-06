package kea.pokedexbackend.db.measurements.count;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;

public interface IDbAverageCounter {
    int count() throws DbConnectionException;
}

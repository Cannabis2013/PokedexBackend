package kea.pokedexbackend.db.measurements.average;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;

public interface IDbAverageGrassHP {
    double get() throws DbConnectionException;
}

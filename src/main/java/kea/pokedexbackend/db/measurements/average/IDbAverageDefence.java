package kea.pokedexbackend.db.measurements.average;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;

public interface IDbAverageDefence {
    double get() throws DbConnectionException;
}

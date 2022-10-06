package kea.pokedexbackend.db.measurements.average;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;

public interface IDbFastestAvgType {
    String get() throws DbConnectionException;
}

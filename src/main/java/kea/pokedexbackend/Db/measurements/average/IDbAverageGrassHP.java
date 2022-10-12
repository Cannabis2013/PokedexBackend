package kea.pokedexbackend.Db.measurements.average;

import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;

public interface IDbAverageGrassHP {
    double get() throws DbConnectionException;
}

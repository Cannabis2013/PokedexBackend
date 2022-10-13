package kea.pokedexbackend.Db.measurements.average;

import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;

public interface IDbAverageGrassHP {
    double get() throws DbConnectionException;
}

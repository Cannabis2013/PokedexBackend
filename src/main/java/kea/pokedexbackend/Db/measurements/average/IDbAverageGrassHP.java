package kea.pokedexbackend.Db.measurements.average;

import kea.pokedexbackend.Dbservices.MySql.Connectors.DbConnectionException;

public interface IDbAverageGrassHP {
    double get() throws DbConnectionException;
}

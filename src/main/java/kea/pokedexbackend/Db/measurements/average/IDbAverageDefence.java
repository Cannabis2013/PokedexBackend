package kea.pokedexbackend.Db.measurements.average;

import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;

public interface IDbAverageDefence {
    double get() throws DbConnectionException;
}

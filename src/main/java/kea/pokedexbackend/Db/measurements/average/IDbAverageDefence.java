package kea.pokedexbackend.Db.measurements.average;

import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;

public interface IDbAverageDefence {
    double get() throws DbConnectionException;
}

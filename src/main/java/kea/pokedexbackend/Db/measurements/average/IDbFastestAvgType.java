package kea.pokedexbackend.Db.measurements.average;

import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;

public interface IDbFastestAvgType {
    String get() throws DbConnectionException;
}

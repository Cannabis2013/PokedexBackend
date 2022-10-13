package kea.pokedexbackend.Db.measurements.average;

import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;

public interface IDbFastestAvgType {
    String get() throws DbConnectionException;
}

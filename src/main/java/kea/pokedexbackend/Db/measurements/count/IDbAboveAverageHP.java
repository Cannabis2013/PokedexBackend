package kea.pokedexbackend.Db.measurements.count;

import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;

public interface IDbAboveAverageHP {
    int count() throws DbConnectionException;
}

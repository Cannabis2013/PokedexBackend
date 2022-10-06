package kea.pokedexbackend.db.measurements.average;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;

public interface IDbAverageCalculator {
    double averageDefence() throws DbConnectionException;
    double averageGrassHP() throws DbConnectionException;
}

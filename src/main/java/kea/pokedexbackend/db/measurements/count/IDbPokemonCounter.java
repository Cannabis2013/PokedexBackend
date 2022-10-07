package kea.pokedexbackend.db.measurements.count;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.models.Measurements.count.CountDetails;

import java.util.List;

public interface IDbPokemonCounter {
    List<CountDetails> count() throws DbConnectionException;
}

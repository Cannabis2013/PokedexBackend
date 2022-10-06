package kea.pokedexbackend.db.measurements.count;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.models.count.CountDetails;

import java.util.List;

public interface IDbPokemonCounter {
    List<CountDetails> countPokemons() throws DbConnectionException;
}

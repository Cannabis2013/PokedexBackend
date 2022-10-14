package kea.pokedexbackend.Contracts.Db.measurements.count;

import kea.pokedexbackend.models.Measurements.count.CountDetails;

import java.util.List;

public interface IDbPokemonCounter {
    List<CountDetails> count();
}

package kea.pokedexbackend.Contracts.Db.CRUD.Add;

import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;

public interface IDbPokemonAdder {
    boolean Add(Pokemon pokemon);
}

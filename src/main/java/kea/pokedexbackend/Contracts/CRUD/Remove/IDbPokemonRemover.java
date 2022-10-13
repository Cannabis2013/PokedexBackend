package kea.pokedexbackend.Contracts.CRUD.Remove;

import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;

public interface IDbPokemonRemover {
    boolean remove(Pokemon pokemon);
}

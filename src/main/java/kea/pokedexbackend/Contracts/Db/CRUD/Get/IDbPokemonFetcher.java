package kea.pokedexbackend.Contracts.Db.CRUD.Get;

import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;

import java.util.List;

public interface IDbPokemonFetcher {
    List<Pokemon> fetch();
    Pokemon fetch(String name);
}

package kea.pokedexbackend.controllers.CRUD;

import kea.pokedexbackend.db.CRUD.Add.IDbPokemonAdder;
import kea.pokedexbackend.db.CRUD.get.IDbPokemonFetcher;

public interface ICRUDServices {
    IDbPokemonFetcher fetcher();

    default IDbPokemonAdder dbPokemonAdder() {
        return null;
    }
}

package kea.pokedexbackend.Contracts.Db.CRUD;

import kea.pokedexbackend.Contracts.Db.CRUD.Add.IDbPokemonAdder;
import kea.pokedexbackend.Contracts.Db.CRUD.Get.IDbPokemonFetcher;
import kea.pokedexbackend.Contracts.Db.CRUD.Remove.IDbPokemonRemover;
import kea.pokedexbackend.Contracts.Responses.IStringResponse;

public interface ICRUDServices {
    IDbPokemonFetcher fetcher();

    IDbPokemonAdder adder();
    IDbPokemonRemover remover();
    IStringResponse resultResponse();
}

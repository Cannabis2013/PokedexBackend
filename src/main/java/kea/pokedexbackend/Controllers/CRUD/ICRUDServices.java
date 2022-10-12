package kea.pokedexbackend.Controllers.CRUD;

import kea.pokedexbackend.Db.CRUD.Add.IDbPokemonAdder;
import kea.pokedexbackend.Db.CRUD.Get.IDbPokemonFetcher;
import kea.pokedexbackend.Db.CRUD.Remove.IDbPokemonRemover;

public interface ICRUDServices {
    IDbPokemonFetcher fetcher();

    IDbPokemonAdder adder();
    IDbPokemonRemover remover();
}

package kea.pokedexbackend.Contracts.CRUD.ServiceProviders;

import kea.pokedexbackend.Contracts.CRUD.Add.IDbPokemonAdder;
import kea.pokedexbackend.Contracts.CRUD.Get.IDbPokemonFetcher;
import kea.pokedexbackend.Contracts.CRUD.Remove.IDbPokemonRemover;
import kea.pokedexbackend.Contracts.Responses.IStringResponse;

public interface ICRUDServices {
    IDbPokemonFetcher fetcher();

    IDbPokemonAdder adder();
    IDbPokemonRemover remover();
    IStringResponse resultResponse();
}

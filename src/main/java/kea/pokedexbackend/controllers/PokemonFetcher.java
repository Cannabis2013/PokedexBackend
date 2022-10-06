package kea.pokedexbackend.controllers;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.db.pokemon.get.IDbPokemonFetcher;
import kea.pokedexbackend.models.pokemon.Pokemon;
import kea.pokedexbackend.utils.json.JSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// http://localhost:8080/

@RestController
public class PokemonFetcher {
    public PokemonFetcher(IDbPokemonFetcher fetcher) {
        _fetcher = fetcher;
    }

    @GetMapping("/getAll")
    public String get(){
        List<Pokemon> pokemons;
        try {
            pokemons = _fetcher.fetch();
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        var jsonResult = JSerializer.serialize(pokemons);
        return jsonResult;
    }

    @GetMapping("/getByName")
    public String getOne(@RequestHeader String name){
        Pokemon pokemon;
        try {
            pokemon = _fetcher.fetch(name);
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        var jsonResult = JSerializer.serialize(pokemon);
        return jsonResult;
    }

    // Services
    private final IDbPokemonFetcher _fetcher;
}

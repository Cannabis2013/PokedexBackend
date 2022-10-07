package kea.pokedexbackend.controllers.CRUD;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import kea.pokedexbackend.utils.json.Generic.JSerializer;
import kea.pokedexbackend.utils.json.Pokemon.PokemonDeserializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// http://localhost:8080/

@RestController
public class PokemonCRUD {

    public PokemonCRUD(ICRUDServices services) {_services = services;}

    @GetMapping("/getAll")
    public String get(){
        List<Pokemon> pokemons;
        try {
            pokemons = _services.fetcher().fetch();
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
            pokemon = _services.fetcher().fetch(name);
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        var jsonResult = JSerializer.serialize(pokemon);
        return jsonResult;
    }

    public String AddPokemon(@RequestBody String json){
        var pokemon = PokemonDeserializer.deserialize(json);
        var result = _services.dbPokemonAdder().Add(pokemon);
        return result ? "Success" : "Fail";
    }

    private final ICRUDServices _services;
}

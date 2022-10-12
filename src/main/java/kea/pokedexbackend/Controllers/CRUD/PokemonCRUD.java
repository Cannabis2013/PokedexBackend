package kea.pokedexbackend.Controllers.CRUD;

import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import kea.pokedexbackend.utils.json.Generic.JSerializer;
import kea.pokedexbackend.utils.json.Pokemon.PokemonDeserializer;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// http://localhost:8080/

@RestController
@CrossOrigin
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

    @GetMapping("addPokemon")
    public String AddPokemon(@RequestBody String json){
        Pokemon pokemon = PokemonDeserializer.deserialize(json);
        boolean result;
        try {
            result = _services.adder().Add(pokemon);
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        return result ? "Success" : "Fail";
    }

    @PostMapping("removePokemon")
    public String removePokemon(@RequestBody String json){
        var pokemon = PokemonDeserializer.deserialize(json);
        boolean result;
        try {
            result = _services.remover().remove(pokemon);
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        return result ? "Success" : "Failed";
    }

    @PatchMapping("UpdatePokemon")
    public String updatePokemon(@RequestBody String json){
        var pokemon = PokemonDeserializer.deserialize(json);
        try {
            var removeResult = _services.remover().remove(pokemon);
            var result = removeResult ? _services.adder().Add(pokemon)  : false;
            return result ? "Success" : "Failed";
        } catch (Exception e){
            return e.getMessage();
        }
    }

    private final ICRUDServices _services;
}

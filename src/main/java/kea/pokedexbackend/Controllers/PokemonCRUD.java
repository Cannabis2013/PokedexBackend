package kea.pokedexbackend.Controllers;

import kea.pokedexbackend.Contracts.CRUD.ServiceProviders.ICRUDServices;
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
        List<Pokemon> pokemons = _services.fetcher().fetch();
        var jsonResult = JSerializer.serialize(pokemons);
        return jsonResult;
    }

    @GetMapping("/getByName")
    public String getOne(@RequestHeader String name){
        var pokemon = _services.fetcher().fetch(name);
        var jsonResult = JSerializer.serialize(pokemon);
        return jsonResult;
    }

    @GetMapping("addPokemon")
    public String AddPokemon(@RequestBody String json){
        var pokemon = PokemonDeserializer.deserialize(json);
        var result = _services.adder().Add(pokemon);
        return _services.resultResponse().response(result);
    }

    @PostMapping("removePokemon")
    public String removePokemon(@RequestBody String json){
        var pokemon = PokemonDeserializer.deserialize(json);
        var result = _services.remover().remove(pokemon);
        return _services.resultResponse().response(result);
    }

    @PatchMapping("UpdatePokemon")
    public String updatePokemon(@RequestBody String json){
        var pokemon = PokemonDeserializer.deserialize(json);
        var removeResult = _services.remover().remove(pokemon);
        var result = removeResult ? _services.adder().Add(pokemon)  : false;
        return _services.resultResponse().response(result);
    }

    private final ICRUDServices _services;
}

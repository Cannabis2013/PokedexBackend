package kea.pokedexbackend.Controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import kea.pokedexbackend.Contracts.Db.CRUD.ICRUDServices;
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
        var pokemons = _services.fetcher().fetch();
        return JSerializer.serialize(pokemons);
    }

    @GetMapping("/getByName")
    public String getOne(@RequestHeader String name){
        var pokemon = _services.fetcher().fetch(name);
        return JSerializer.serialize(pokemon);
    }

    @GetMapping("addPokemon")
    public String AddPokemon(@RequestBody @ModelAttribute Pokemon pokemon){
        var result = _services.adder().Add(pokemon);
        return _services.resultResponse().response(result);
    }

    @PostMapping("removePokemon")
    public String removePokemon(@ModelAttribute Pokemon pokemon){
        var result = _services.remover().remove(pokemon);
        return _services.resultResponse().response(result);
    }

    @PatchMapping("UpdatePokemon")
    public String updatePokemon(@ModelAttribute Pokemon pokemon){
        var removeResult = _services.remover().remove(pokemon);
        var result = removeResult ? _services.adder().Add(pokemon)  : false;
        return _services.resultResponse().response(result);
    }

    private final ICRUDServices _services;
}

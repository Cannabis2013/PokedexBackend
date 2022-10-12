package kea.pokedexbackend.utils.json.Pokemon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;

public class PokemonDeserializer {
    public static Pokemon deserialize(String json) {
        var mapper = new JsonMapper();
        try {
            return mapper.readValue(json, Pokemon.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

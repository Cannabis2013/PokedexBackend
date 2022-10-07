package kea.pokedexbackend.utils.json.Generic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;

import java.io.IOException;
import java.io.StringWriter;

public class JSerializer {
    public static  String serialize(Object obj){
        var mapper = getJsonMapper();
        var writer = new StringWriter();
        try {
            mapper.writeValue(writer,obj);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        var json = writer.toString();
        return json;
    }



    private static ObjectMapper getJsonMapper(){
        var mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }
}

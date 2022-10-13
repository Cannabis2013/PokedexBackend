package kea.pokedexbackend.utils.json.Generic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.StringWriter;

public class JSerializer {
    public static  String serialize(Object obj){
        var mapper = jsonMapper();
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



    private static ObjectMapper jsonMapper(){
        var mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }
}

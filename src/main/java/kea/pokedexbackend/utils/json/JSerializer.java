package kea.pokedexbackend.utils.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.io.StringWriter;

public class JSerializer {
    public static  String serialize(Object obj){
        var entities = obj;
        var mapper = buildJsonMapper();
        var writer = new StringWriter();
        try {
            mapper.writeValue(writer,entities);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        var json = writer.toString();
        return json;
    }

    private static ObjectMapper buildJsonMapper(){
        var mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }
}

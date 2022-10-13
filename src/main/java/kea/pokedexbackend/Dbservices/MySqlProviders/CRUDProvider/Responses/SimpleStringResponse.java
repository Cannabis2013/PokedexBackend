package kea.pokedexbackend.Dbservices.MySqlProviders.CRUDProvider.Responses;

import kea.pokedexbackend.Db.Responses.IStringResponse;
import org.springframework.stereotype.Service;

@Service
public class SimpleStringResponse implements IStringResponse {
    @Override
    public String response(boolean result) {
        return result ? "Success" : "Fail";
    }
}

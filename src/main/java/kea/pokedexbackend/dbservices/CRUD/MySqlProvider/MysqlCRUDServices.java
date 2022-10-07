package kea.pokedexbackend.dbservices.CRUD.MySqlProvider;

import kea.pokedexbackend.controllers.CRUD.ICRUDServices;
import kea.pokedexbackend.db.CRUD.get.IDbPokemonFetcher;
import org.springframework.stereotype.Service;

@Service
public class MysqlCRUDServices implements ICRUDServices {
    public MysqlCRUDServices(IDbPokemonFetcher fetcher) {
        _fetcher = fetcher;
    }

    @Override
    public IDbPokemonFetcher fetcher() {
        return _fetcher;
    }

    private final IDbPokemonFetcher _fetcher;
}

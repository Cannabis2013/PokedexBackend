package kea.pokedexbackend.Services.MySqlProviders.CRUDProvider;

import kea.pokedexbackend.Contracts.CRUD.ServiceProviders.ICRUDServices;
import kea.pokedexbackend.Contracts.CRUD.Add.IDbPokemonAdder;
import kea.pokedexbackend.Contracts.CRUD.Get.IDbPokemonFetcher;
import kea.pokedexbackend.Contracts.CRUD.Remove.IDbPokemonRemover;
import kea.pokedexbackend.Contracts.Connector.IDbConnection;
import kea.pokedexbackend.Contracts.Responses.IStringResponse;
import kea.pokedexbackend.Services.MySqlProviders.CRUDProvider.Add.MySqlPokemonAdder;
import kea.pokedexbackend.Services.MySqlProviders.CRUDProvider.Get.MySqlPokemonFetch;
import kea.pokedexbackend.Services.MySqlProviders.CRUDProvider.Remove.MysqlPokemonRemover;
import kea.pokedexbackend.Services.Responses.SimpleStringResponse;
import org.springframework.stereotype.Service;

@Service
public class MysqlCRUDServices implements ICRUDServices {
    public MysqlCRUDServices(IDbConnection dbConnector) {
        _fetcher = new MySqlPokemonFetch(dbConnector);
        _adder = new MySqlPokemonAdder(dbConnector);
        _remover = new MysqlPokemonRemover(dbConnector);
        _response = new SimpleStringResponse();
    }

    @Override
    public IDbPokemonFetcher fetcher() {
        return _fetcher;
    }

    @Override
    public IDbPokemonAdder adder() {
        return _adder;
    }

    @Override
    public IDbPokemonRemover remover() {
        return _remover;
    }

    @Override
    public IStringResponse resultResponse() {
        return _response;
    }

    private final IDbPokemonFetcher _fetcher;
    private final IDbPokemonAdder _adder;
    private final IDbPokemonRemover _remover;
    private final IStringResponse _response;
}

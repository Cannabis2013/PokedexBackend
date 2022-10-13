package kea.pokedexbackend.Dbservices.MySql.ServiceProviders.CRUDProvider;

import kea.pokedexbackend.Controllers.CRUD.ICRUDServices;
import kea.pokedexbackend.Db.CRUD.Add.IDbPokemonAdder;
import kea.pokedexbackend.Db.CRUD.Get.IDbPokemonFetcher;
import kea.pokedexbackend.Db.CRUD.Remove.IDbPokemonRemover;
import kea.pokedexbackend.Db.Connector.IDbConnector;
import kea.pokedexbackend.Dbservices.MySql.ServiceProviders.CRUDProvider.Add.MySqlPokemonAdder;
import kea.pokedexbackend.Dbservices.MySql.ServiceProviders.CRUDProvider.Fetcher.MySqlPokemonFetch;
import kea.pokedexbackend.Dbservices.MySql.ServiceProviders.CRUDProvider.Remove.MysqlPokemonRemover;
import org.springframework.stereotype.Service;

@Service
public class MysqlCRUDServices implements ICRUDServices {
    public MysqlCRUDServices(IDbConnector dbConnector) {
        _fetcher = new MySqlPokemonFetch(dbConnector);
        _adder = new MySqlPokemonAdder(dbConnector);
        _remover = new MysqlPokemonRemover(dbConnector);
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

    private final IDbPokemonFetcher _fetcher;
    private final IDbPokemonAdder _adder;
    private final IDbPokemonRemover _remover;
}

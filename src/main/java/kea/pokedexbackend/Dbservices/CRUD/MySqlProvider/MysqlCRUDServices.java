package kea.pokedexbackend.Dbservices.CRUD.MySqlProvider;

import kea.pokedexbackend.Controllers.CRUD.ICRUDServices;
import kea.pokedexbackend.Db.CRUD.Add.IDbPokemonAdder;
import kea.pokedexbackend.Db.CRUD.Get.IDbPokemonFetcher;
import kea.pokedexbackend.Db.CRUD.Remove.IDbPokemonRemover;
import kea.pokedexbackend.Dbservices.CRUD.MySqlProvider.Add.MySqlPokemonAdder;
import kea.pokedexbackend.Dbservices.CRUD.MySqlProvider.Fetcher.MySqlPokemonFetch;
import kea.pokedexbackend.Dbservices.CRUD.MySqlProvider.Remove.MysqlPokemonRemover;
import org.springframework.stereotype.Service;

@Service
public class MysqlCRUDServices implements ICRUDServices {
    public MysqlCRUDServices() {
        _fetcher = new MySqlPokemonFetch();
        _adder = new MySqlPokemonAdder();
        _remover = new MysqlPokemonRemover();
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

package kea.pokedexbackend.DbServices.MySqlProviders.CRUDProvider.Get;

import kea.pokedexbackend.Contracts.Db.CRUD.Get.IDbPokemonFetcher;
import kea.pokedexbackend.Contracts.Db.Connector.IDbConnection;
import kea.pokedexbackend.DbServices.MySqlProviders.CRUDProvider.Converter.ResultConverter;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;

import java.util.List;



public class MySqlPokemonFetch implements IDbPokemonFetcher {
    public MySqlPokemonFetch(IDbConnection dbConnector) {
        _dbConnection = dbConnector;
    }

    @Override
    public List<Pokemon> fetch() {
        var query = "select * from pokemon";
        var dbResult = _dbConnection.performQuery(query);
        var pokemons = ResultConverter.convertAll(dbResult);
        return pokemons;
    }

    @Override
    public Pokemon fetch(String name){
        var query = String.format("select * from pokemon where name='%s';",name);
        var dbResult = _dbConnection.performQuery(query);
        var pokemon = ResultConverter.convert(dbResult);
        return pokemon;
    }

    private final IDbConnection _dbConnection;
}

package kea.pokedexbackend.Db.CRUD.Get;

import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;
import java.util.List;

public interface IDbPokemonFetcher {
    List<Pokemon> fetch() throws DbConnectionException;
    Pokemon fetch(String name) throws DbConnectionException;
}

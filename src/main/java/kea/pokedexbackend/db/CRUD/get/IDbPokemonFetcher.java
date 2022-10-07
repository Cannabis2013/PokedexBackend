package kea.pokedexbackend.db.CRUD.get;

import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import java.util.List;

public interface IDbPokemonFetcher {
    List<Pokemon> fetch() throws DbConnectionException;
    Pokemon fetch(String name) throws DbConnectionException;
}

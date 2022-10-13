package kea.pokedexbackend.Db.CRUD.Remove;

import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;

public interface IDbPokemonRemover {
    boolean remove(Pokemon pokemon) throws DbConnectionException;
}

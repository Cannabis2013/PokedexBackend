package kea.pokedexbackend.Db.CRUD.Add;

import kea.pokedexbackend.Dbservices.MySql.Connectors.DbConnectionException;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;

public interface IDbPokemonAdder {
    boolean Add(Pokemon pokemon) throws DbConnectionException;
}

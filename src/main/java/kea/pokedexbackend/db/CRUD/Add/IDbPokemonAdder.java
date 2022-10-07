package kea.pokedexbackend.db.CRUD.Add;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;

public interface IDbPokemonAdder {
    boolean Add(Pokemon pokemon) throws DbConnectionException;
}

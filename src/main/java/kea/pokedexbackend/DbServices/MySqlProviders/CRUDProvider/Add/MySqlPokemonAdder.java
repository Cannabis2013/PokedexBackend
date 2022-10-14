package kea.pokedexbackend.DbServices.MySqlProviders.CRUDProvider.Add;

import kea.pokedexbackend.Contracts.Db.CRUD.Add.IDbPokemonAdder;
import kea.pokedexbackend.Contracts.Db.Connector.IDbConnection;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;

public class MySqlPokemonAdder implements IDbPokemonAdder {
    public MySqlPokemonAdder(IDbConnection dbConnector) {
        _dbConnection = dbConnector;
    }

    @Override
    public boolean Add(Pokemon pokemon) {
        if(pokemon == null)
            return false;
        var statement = statement(pokemon);
        return _dbConnection.performStatement(statement);
    }

    private String statement(Pokemon pokemon){
        var query = String.format("""
                            INSERT INTO 
                            pokemon(pokedex_number,name,speed,
                                    special_defence,special_attack, 
                                    defence,attack,hp,
                                    primary_type,secondary_type) 
                            VALUES('%d', '%s','%d','%d','%d','%d',
                            '%d','%d','%s','%s');
                        """,
                pokemon.pokedexNumber, pokemon.name,pokemon.speed,
                pokemon.special_defence, pokemon.special_attack,
                pokemon.defence,
                pokemon.attack,pokemon.hp,pokemon.primaryType,
                pokemon.secondaryType
        );
        return query;
    }

    private final IDbConnection _dbConnection;
}

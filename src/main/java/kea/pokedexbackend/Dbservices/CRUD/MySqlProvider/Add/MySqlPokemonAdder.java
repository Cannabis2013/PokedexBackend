package kea.pokedexbackend.Dbservices.CRUD.MySqlProvider.Add;

import kea.pokedexbackend.Db.CRUD.Add.IDbPokemonAdder;
import kea.pokedexbackend.Dbservices.Connectionbuilders.MysqlConnection;
import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import java.sql.SQLException;

public class MySqlPokemonAdder implements IDbPokemonAdder {
    @Override
    public boolean Add(Pokemon pokemon) throws DbConnectionException {
        if(pokemon == null)
            return false;
        var query = toQuery(pokemon);
        try {
            return !MysqlConnection.get().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String toQuery(Pokemon pokemon){
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
}

package kea.pokedexbackend.Dbservices.MySql.ServiceProviders.CRUDProvider.Converter;

import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultConverter {
    public static List<Pokemon> convertAll(ResultSet set) throws SQLException {
        var pokemons = new ArrayList<Pokemon>();
        while (set.next())
        {
            var pokemon = ToPokemon(set);
            pokemons.add(pokemon);
        }
        return pokemons;
    }

    public static Pokemon convert(ResultSet set) throws SQLException {
        if(!set.next())
            return new Pokemon();
        var pokemon = ToPokemon(set);
        return pokemon;
    }

    private static Pokemon ToPokemon(ResultSet set) throws SQLException {
        var pokemon = new Pokemon(){{
            id = set.getInt("id");
            pokedexNumber = set.getInt("pokedex_number");
            name = set.getString("name");
            speed = set.getInt("speed");
            special_defence = set.getInt("special_defence");
            special_attack = set.getInt("special_attack");
            defence = set.getInt("defence");
            attack = set.getInt("attack");
            hp = set.getInt("hp");
            primaryType = set.getString("primary_type");
            secondaryType = set.getString("secondary_type");
        }};
        return pokemon;
    }
}

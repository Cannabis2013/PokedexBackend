package kea.pokedexbackend.Services.MySqlProviders.CRUDProvider.Converter;

import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultConverter {
    public static List<Pokemon> convertAll(ResultSet set) {
        var pokemons = new ArrayList<Pokemon>();
        try {
            while (set.next())
            {
                var pokemon = ToPokemon(set);
                pokemons.add(pokemon);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
        return pokemons;
    }

    public static Pokemon convert(ResultSet set) {
        try {
            if(!set.next())
                return new Pokemon();
            return ToPokemon(set);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Pokemon();
        }
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

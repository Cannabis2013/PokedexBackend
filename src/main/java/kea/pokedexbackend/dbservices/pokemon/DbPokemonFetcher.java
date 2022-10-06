package kea.pokedexbackend.dbservices.pokemon;

import kea.pokedexbackend.db.pokemon.get.IDbPokemonFetcher;
import kea.pokedexbackend.models.pokemon.Pokemon;
import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.db.connectionbuilders.IConnectionBuilder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DbPokemonFetcher implements IDbPokemonFetcher {
    public DbPokemonFetcher(IConnectionBuilder dbConBuilder) {
        _dbConBuilder = dbConBuilder;
    }

    @Override
    public List<Pokemon> fetch() throws DbConnectionException {
        var dbConnection = _dbConBuilder.build();
        try {
            var st = dbConnection.createStatement();
            var result = st.executeQuery("select * from pokemon");
            return ResultConverter.convertAll(result);
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Pokemon fetch(String name) throws DbConnectionException {
        var dbConnection = _dbConBuilder.build();
        var query = String.format("select * from pokemon where name='%s';",name);
        try {
            var dbResult = dbConnection.createStatement().executeQuery(query);
            return ResultConverter.convert(dbResult);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Services
    private final IConnectionBuilder _dbConBuilder;
}

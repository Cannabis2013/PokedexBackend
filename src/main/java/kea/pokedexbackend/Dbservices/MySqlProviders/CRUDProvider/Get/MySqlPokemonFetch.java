package kea.pokedexbackend.Dbservices.MySqlProviders.CRUDProvider.Get;

import kea.pokedexbackend.Db.CRUD.Get.IDbPokemonFetcher;
import kea.pokedexbackend.Db.Connector.IDbConnection;
import kea.pokedexbackend.Dbservices.MySqlProviders.CRUDProvider.Converter.ResultConverter;
import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPokemonFetch implements IDbPokemonFetcher {
    public MySqlPokemonFetch(IDbConnection dbConnector) {
        _dbConnector = dbConnector;
    }

    @Override
    public List<Pokemon> fetch() throws DbConnectionException {
        try {
            var st = _dbConnector.get().createStatement();
            var result = st.executeQuery("select * from pokemon");
            return ResultConverter.convertAll(result);
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Pokemon fetch(String name) throws DbConnectionException {
        var query = String.format("select * from pokemon where name='%s';",name);
        try {
            var dbResult = _dbConnector.get().createStatement().executeQuery(query);
            return ResultConverter.convert(dbResult);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private final IDbConnection _dbConnector;
}
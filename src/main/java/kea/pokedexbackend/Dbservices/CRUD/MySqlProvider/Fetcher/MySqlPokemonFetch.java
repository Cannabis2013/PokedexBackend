package kea.pokedexbackend.Dbservices.CRUD.MySqlProvider.Fetcher;

import kea.pokedexbackend.Db.CRUD.Get.IDbPokemonFetcher;
import kea.pokedexbackend.Dbservices.CRUD.MySqlProvider.Converter.ResultConverter;
import kea.pokedexbackend.Dbservices.Connectionbuilders.MysqlConnection;
import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPokemonFetch implements IDbPokemonFetcher {
    @Override
    public List<Pokemon> fetch() throws DbConnectionException {
        try {
            var st = MysqlConnection.get().createStatement();
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
            var dbResult = MysqlConnection.get().createStatement().executeQuery(query);
            return ResultConverter.convert(dbResult);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

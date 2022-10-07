package kea.pokedexbackend.dbservices.CRUD.MySqlProvider.Add;

import kea.pokedexbackend.db.CRUD.Add.IDbPokemonAdder;
import kea.pokedexbackend.db.connectionbuilders.ConnectionProvider;
import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.db.connectionbuilders.IConnectionBuilder;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbPokemonAdder extends ConnectionProvider implements IDbPokemonAdder {
    protected DbPokemonAdder(IConnectionBuilder builder) {
        super(builder);
    }

    @Override
    public boolean Add(Pokemon pokemon) throws DbConnectionException {
        var con = getConnection();
        ResultSet dbResult;
        try {
            dbResult = getConnection().prepareStatement("""
                                                
                                            """).executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}

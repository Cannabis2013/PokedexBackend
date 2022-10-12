package kea.pokedexbackend.Dbservices.CRUD.MySqlProvider.Remove;

import kea.pokedexbackend.Db.CRUD.Remove.IDbPokemonRemover;
import kea.pokedexbackend.Dbservices.Connectionbuilders.MysqlConnection;
import kea.pokedexbackend.Dbservices.Connectionbuilders.DbConnectionException;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MysqlPokemonRemover implements IDbPokemonRemover {
    @Override
    public boolean remove(Pokemon pokemon) throws DbConnectionException {
        if(!pokemonExists(pokemon.id))
            return false;
        try {
            var sql = String.format(
                    """
                        DELETE FROM pokemon
                        WHERE id=%d
                    """,pokemon.id
            );
            MysqlConnection.get().createStatement().execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean pokemonExists(int id) throws DbConnectionException {
        try {
            ResultSet dbResult = MysqlConnection.get()
                    .createStatement()
                    .executeQuery(
                            String.format(
                            """
                                SELECT COUNT(*) count
                                FROM pokemon p
                                WHERE id = %d;
                            """, id)
                    );
            return getResult(dbResult);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean getResult(ResultSet dbResult) throws SQLException {
        if(dbResult.next()){
            var count = dbResult.getInt("count");
            return count == 1;
        }
        return false;
    }
}

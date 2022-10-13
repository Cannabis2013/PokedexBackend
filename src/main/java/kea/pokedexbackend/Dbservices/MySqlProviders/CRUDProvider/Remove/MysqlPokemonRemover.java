package kea.pokedexbackend.Dbservices.MySqlProviders.CRUDProvider.Remove;

import kea.pokedexbackend.Db.CRUD.Remove.IDbPokemonRemover;
import kea.pokedexbackend.Db.Connector.IDbConnection;
import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MysqlPokemonRemover implements IDbPokemonRemover {
    public MysqlPokemonRemover(IDbConnection dbConnector) {
        _dbConnector = dbConnector;
    }

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
            _dbConnector.get().createStatement().execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean pokemonExists(int id) throws DbConnectionException {
        try {
            ResultSet dbResult = _dbConnector.get()
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

    private final IDbConnection _dbConnector;
}

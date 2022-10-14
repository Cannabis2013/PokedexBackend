package kea.pokedexbackend.DbServices.MySqlProviders.CRUDProvider.Remove;

import kea.pokedexbackend.Contracts.Db.CRUD.Remove.IDbPokemonRemover;
import kea.pokedexbackend.Contracts.Db.Connector.IDbConnection;
import kea.pokedexbackend.models.CRUD.pokemon.Pokemon;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MysqlPokemonRemover implements IDbPokemonRemover {
    public MysqlPokemonRemover(IDbConnection dbConnector) {
        _dbConnection = dbConnector;
    }

    @Override
    public boolean remove(Pokemon pokemon) {
        if(!pokemonExists(pokemon))
            return false;
        var statement = deleteStatement(pokemon);
        return _dbConnection.performStatement(statement);
    }

    private boolean pokemonExists(Pokemon pokemon) {
        var query = countQuery(pokemon);
        var result = _dbConnection.performQuery(query);
        if(result != null)
            return getResult(result);
        return false;
    }

    private String deleteStatement(Pokemon pokemon){
        return String.format(
                """
                    DELETE FROM pokemon
                    WHERE id=%d
                """,pokemon.id
        );
    }

    private String countQuery(Pokemon pokemon){
        return String.format(
                """
                    SELECT COUNT(*) count
                    FROM pokemon p
                    WHERE id = %d;
                """, pokemon.id);
    }

    private boolean getResult(ResultSet dbResult) {
        try {
            if(dbResult.next()){
                var count = dbResult.getInt("count");
                return count == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private final IDbConnection _dbConnection;
}

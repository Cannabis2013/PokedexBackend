package kea.pokedexbackend.Db.measurements.count;

import kea.pokedexbackend.Dbservices.Connectors.DbConnectionException;
import kea.pokedexbackend.models.Measurements.count.CountDetails;

import java.util.List;

public interface IDbPokemonCounter {
    List<CountDetails> count() throws DbConnectionException;
}

package kea.pokedexbackend.controllers;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.db.measurements.average.IDbAverageCalculator;
import kea.pokedexbackend.db.measurements.count.IDbAverageCounter;
import kea.pokedexbackend.db.measurements.count.IDbPokemonCounter;
import kea.pokedexbackend.models.count.CountDetails;
import kea.pokedexbackend.utils.json.JSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PokemonMeasurements {
    public PokemonMeasurements(IDbPokemonCounter counter, IDbAverageCalculator avgDefence,
                               IDbAverageCounter avgHPCounter) {
        _counter = counter;
        _avgDefence = avgDefence;
        _avgHPCounter = avgHPCounter;
    }

    @GetMapping("countTypes")
    public String countByPrimary(){
        List<CountDetails> counts;
        try {
            counts = _counter.countPokemons();
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        return JSerializer.serialize(counts);
    }

    @GetMapping("avgDef")
    public String averageDefence(){
        double avg;
        try {
            avg = _avgDefence.averageDefence();
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        return String.valueOf(avg);
    }

    @GetMapping("gtAvgHpCount")
    public String greaterThanAverageHpCount(){
        double avg;
        try {
            avg = _avgHPCounter.count();
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        return String.valueOf(avg);
    }
    private final IDbPokemonCounter _counter;
    private final IDbAverageCalculator _avgDefence;
    private final IDbAverageCounter _avgHPCounter;
}

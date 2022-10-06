package kea.pokedexbackend.controllers;

import kea.pokedexbackend.db.connectionbuilders.DbConnectionException;
import kea.pokedexbackend.db.measurements.average.IDbAverageDefence;
import kea.pokedexbackend.db.measurements.average.IDbAverageGrassHP;
import kea.pokedexbackend.db.measurements.average.IDbFastestAvgType;
import kea.pokedexbackend.db.measurements.count.IDbAverageCounter;
import kea.pokedexbackend.db.measurements.count.IDbPokemonCounter;
import kea.pokedexbackend.models.count.CountDetails;
import kea.pokedexbackend.utils.json.JSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PokemonMeasurements {
    public PokemonMeasurements(IDbPokemonCounter counter, IDbAverageDefence avgDefence,
                               IDbAverageGrassHP averageGrassHPValue, IDbAverageCounter avgHPCounter, IDbFastestAvgType fastestAvgTypeValue) {
        _counter = counter;
        _averageDefenceValue = avgDefence;
        _averageGrassHPValue = averageGrassHPValue;
        _avgHPCounter = avgHPCounter;
        _fastestAvgTypeValue = fastestAvgTypeValue;
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
            avg = _averageDefenceValue.get();
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        return String.valueOf(avg);
    }

    @GetMapping("avgGrassHP")
    public String averageGrassHP(){
        double avg;
        try {
            avg = _averageGrassHPValue.get();
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

    @GetMapping("fastestAvgType")
    public String fastestType(){
        try {
            return _fastestAvgTypeValue.get();
        } catch (DbConnectionException e){
            return e.getMessage();
        }
    }

    private final IDbPokemonCounter _counter;
    private final IDbAverageDefence _averageDefenceValue;
    private final IDbAverageGrassHP _averageGrassHPValue;
    private final IDbAverageCounter _avgHPCounter;
    private final IDbFastestAvgType _fastestAvgTypeValue;
}

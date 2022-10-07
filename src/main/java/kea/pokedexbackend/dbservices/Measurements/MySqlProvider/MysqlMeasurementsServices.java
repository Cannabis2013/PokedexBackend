package kea.pokedexbackend.dbservices.Measurements.MySqlProvider;

import kea.pokedexbackend.controllers.measurements.IPokemonMeasureServices;
import kea.pokedexbackend.db.measurements.average.IDbAverageDefence;
import kea.pokedexbackend.db.measurements.average.IDbAverageGrassHP;
import kea.pokedexbackend.db.measurements.average.IDbFastestAvgType;
import kea.pokedexbackend.db.measurements.count.IDbAboveAverageHP;
import kea.pokedexbackend.db.measurements.count.IDbPokemonCounter;
import org.springframework.stereotype.Service;

@Service
public class MysqlMeasurementsServices implements IPokemonMeasureServices {
    public MysqlMeasurementsServices(IDbPokemonCounter pokemonCounter, IDbAverageDefence avgDefCalculator, IDbAverageGrassHP avgGrassHp, IDbAboveAverageHP avgHPCounter, IDbFastestAvgType fastestPrimaryType) {
        _pokemonCounter = pokemonCounter;
        _avgDefCalculator = avgDefCalculator;
        _avgGrassHp = avgGrassHp;
        _avgHPCounter = avgHPCounter;
        _fastestPrimaryType = fastestPrimaryType;
    }

    @Override
    public IDbPokemonCounter counter() {return _pokemonCounter;}

    @Override
    public IDbAverageDefence avgDefValue() {return _avgDefCalculator;}

    @Override
    public IDbAverageGrassHP avgGrassHPValue() {return _avgGrassHp;}

    @Override
    public IDbAboveAverageHP avgHPCounter() {return _avgHPCounter;}

    @Override
    public IDbFastestAvgType fastestAvgTypeValue() {return _fastestPrimaryType;}

    private final IDbPokemonCounter _pokemonCounter;
    private final IDbAverageDefence _avgDefCalculator;
    private final IDbAverageGrassHP _avgGrassHp;
    private final IDbAboveAverageHP _avgHPCounter;
    private final IDbFastestAvgType _fastestPrimaryType;
}

package kea.pokedexbackend.Dbservices.Measurements.MySqlProvider;

import kea.pokedexbackend.Controllers.Measurements.IPokemonMeasureServices;
import kea.pokedexbackend.Db.measurements.average.IDbAverageDefence;
import kea.pokedexbackend.Db.measurements.average.IDbAverageGrassHP;
import kea.pokedexbackend.Db.measurements.average.IDbFastestAvgType;
import kea.pokedexbackend.Db.measurements.count.IDbAboveAverageHP;
import kea.pokedexbackend.Db.measurements.count.IDbPokemonCounter;
import kea.pokedexbackend.Dbservices.Measurements.MySqlProvider.average.MySqlFastestPrimaryType;
import kea.pokedexbackend.Dbservices.Measurements.MySqlProvider.average.MySqlAverageGrassHP;
import kea.pokedexbackend.Dbservices.Measurements.MySqlProvider.average.MySqlAverageDefence;
import kea.pokedexbackend.Dbservices.Measurements.MySqlProvider.count.MySqlAboveAverageHP;
import kea.pokedexbackend.Dbservices.Measurements.MySqlProvider.count.MySqlPokemonCount;
import org.springframework.stereotype.Service;

@Service
public class MysqlMeasurementsServices implements IPokemonMeasureServices {
    public MysqlMeasurementsServices() {
        _pokemonCounter = new MySqlPokemonCount();
        _avgDefCalculator = new MySqlAverageDefence();
        _avgGrassHp = new MySqlAverageGrassHP();
        _avgHPCounter = new MySqlAboveAverageHP();
        _fastestPrimaryType = new MySqlFastestPrimaryType();
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

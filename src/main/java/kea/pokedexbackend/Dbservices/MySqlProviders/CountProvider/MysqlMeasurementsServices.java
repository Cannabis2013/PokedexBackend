package kea.pokedexbackend.Dbservices.MySqlProviders.CountProvider;

import kea.pokedexbackend.Controllers.Measurements.IPokemonMeasureServices;
import kea.pokedexbackend.Db.Connector.IDbConnector;
import kea.pokedexbackend.Db.measurements.average.IDbAverageDefence;
import kea.pokedexbackend.Db.measurements.average.IDbAverageGrassHP;
import kea.pokedexbackend.Db.measurements.average.IDbFastestAvgType;
import kea.pokedexbackend.Db.measurements.count.IDbAboveAverageHP;
import kea.pokedexbackend.Db.measurements.count.IDbPokemonCounter;
import kea.pokedexbackend.Dbservices.MySqlProviders.CountProvider.average.MySqlAverageGrassHP;
import kea.pokedexbackend.Dbservices.MySqlProviders.CountProvider.average.MySqlFastestPrimaryType;
import kea.pokedexbackend.Dbservices.MySqlProviders.CountProvider.count.MySqlAboveAverageHP;
import kea.pokedexbackend.Dbservices.MySqlProviders.CountProvider.count.MySqlPokemonCount;
import kea.pokedexbackend.Dbservices.MySqlProviders.CountProvider.average.MySqlAverageDefence;
import org.springframework.stereotype.Service;

@Service
public class MysqlMeasurementsServices implements IPokemonMeasureServices {
    public MysqlMeasurementsServices(IDbConnector dbConnector) {
        _pokemonCounter = new MySqlPokemonCount(dbConnector);
        _avgDefCalculator = new MySqlAverageDefence(dbConnector);
        _avgGrassHp = new MySqlAverageGrassHP(dbConnector);
        _avgHPCounter = new MySqlAboveAverageHP(dbConnector);
        _fastestPrimaryType = new MySqlFastestPrimaryType(dbConnector);
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

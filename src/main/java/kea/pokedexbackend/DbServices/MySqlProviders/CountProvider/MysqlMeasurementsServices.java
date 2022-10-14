package kea.pokedexbackend.DbServices.MySqlProviders.CountProvider;

import kea.pokedexbackend.Contracts.Db.measurements.ServiceProviders.IPokemonMeasureServices;
import kea.pokedexbackend.Contracts.Db.Connector.IDbConnection;
import kea.pokedexbackend.Contracts.Db.measurements.average.IDbAverageDefence;
import kea.pokedexbackend.Contracts.Db.measurements.average.IDbAverageGrassHP;
import kea.pokedexbackend.Contracts.Db.measurements.average.IDbFastestAvgType;
import kea.pokedexbackend.Contracts.Db.measurements.count.IDbAboveAverageHP;
import kea.pokedexbackend.Contracts.Db.measurements.count.IDbPokemonCounter;
import kea.pokedexbackend.DbServices.MySqlProviders.CountProvider.average.MySqlAverageGrassHP;
import kea.pokedexbackend.DbServices.MySqlProviders.CountProvider.average.MySqlFastestPrimaryType;
import kea.pokedexbackend.DbServices.MySqlProviders.CountProvider.count.MySqlAboveAverageHP;
import kea.pokedexbackend.DbServices.MySqlProviders.CountProvider.count.MySqlPokemonCount;
import kea.pokedexbackend.DbServices.MySqlProviders.CountProvider.average.MySqlAverageDefence;
import org.springframework.stereotype.Service;

@Service
public class MysqlMeasurementsServices implements IPokemonMeasureServices {
    public MysqlMeasurementsServices(IDbConnection dbConnector) {
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

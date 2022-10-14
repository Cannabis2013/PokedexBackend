package kea.pokedexbackend.Contracts.Db.measurements.ServiceProviders;

import kea.pokedexbackend.Contracts.Db.measurements.average.IDbAverageDefence;
import kea.pokedexbackend.Contracts.Db.measurements.average.IDbAverageGrassHP;
import kea.pokedexbackend.Contracts.Db.measurements.average.IDbFastestAvgType;
import kea.pokedexbackend.Contracts.Db.measurements.count.IDbAboveAverageHP;
import kea.pokedexbackend.Contracts.Db.measurements.count.IDbPokemonCounter;

public interface IPokemonMeasureServices {
    IDbPokemonCounter counter();
    IDbAverageDefence avgDefValue();
    IDbAverageGrassHP avgGrassHPValue();
    IDbAboveAverageHP avgHPCounter();
    IDbFastestAvgType fastestAvgTypeValue();
}

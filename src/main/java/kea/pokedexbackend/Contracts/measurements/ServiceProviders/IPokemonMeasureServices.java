package kea.pokedexbackend.Contracts.measurements.ServiceProviders;

import kea.pokedexbackend.Contracts.measurements.average.IDbAverageDefence;
import kea.pokedexbackend.Contracts.measurements.average.IDbAverageGrassHP;
import kea.pokedexbackend.Contracts.measurements.average.IDbFastestAvgType;
import kea.pokedexbackend.Contracts.measurements.count.IDbAboveAverageHP;
import kea.pokedexbackend.Contracts.measurements.count.IDbPokemonCounter;

public interface IPokemonMeasureServices {
    IDbPokemonCounter counter();
    IDbAverageDefence avgDefValue();
    IDbAverageGrassHP avgGrassHPValue();
    IDbAboveAverageHP avgHPCounter();
    IDbFastestAvgType fastestAvgTypeValue();
}

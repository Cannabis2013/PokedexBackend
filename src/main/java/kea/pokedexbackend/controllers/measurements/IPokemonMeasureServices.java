package kea.pokedexbackend.controllers.measurements;

import kea.pokedexbackend.db.measurements.average.IDbAverageDefence;
import kea.pokedexbackend.db.measurements.average.IDbAverageGrassHP;
import kea.pokedexbackend.db.measurements.average.IDbFastestAvgType;
import kea.pokedexbackend.db.measurements.count.IDbAboveAverageHP;
import kea.pokedexbackend.db.measurements.count.IDbPokemonCounter;

public interface IPokemonMeasureServices {
    IDbPokemonCounter counter();
    IDbAverageDefence avgDefValue();
    IDbAverageGrassHP avgGrassHPValue();
    IDbAboveAverageHP avgHPCounter();
    IDbFastestAvgType fastestAvgTypeValue();
}

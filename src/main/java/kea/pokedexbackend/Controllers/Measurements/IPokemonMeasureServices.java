package kea.pokedexbackend.Controllers.Measurements;

import kea.pokedexbackend.Db.measurements.average.IDbAverageDefence;
import kea.pokedexbackend.Db.measurements.average.IDbAverageGrassHP;
import kea.pokedexbackend.Db.measurements.average.IDbFastestAvgType;
import kea.pokedexbackend.Db.measurements.count.IDbAboveAverageHP;
import kea.pokedexbackend.Db.measurements.count.IDbPokemonCounter;

public interface IPokemonMeasureServices {
    IDbPokemonCounter counter();
    IDbAverageDefence avgDefValue();
    IDbAverageGrassHP avgGrassHPValue();
    IDbAboveAverageHP avgHPCounter();
    IDbFastestAvgType fastestAvgTypeValue();
}

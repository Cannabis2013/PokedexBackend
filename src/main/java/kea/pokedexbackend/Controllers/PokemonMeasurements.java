package kea.pokedexbackend.Controllers;

import kea.pokedexbackend.Contracts.Db.measurements.ServiceProviders.IPokemonMeasureServices;
import kea.pokedexbackend.utils.json.Generic.JSerializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PokemonMeasurements {
    public PokemonMeasurements(IPokemonMeasureServices services) {_services = services;}

    @GetMapping("countTypes")
    public String countByPrimary(){
        var counts = _services.counter().count();
        return JSerializer.serialize(counts);
    }

    @GetMapping("avgDef")
    public String averageDefence(){
        var avg = _services.avgDefValue().get();
        return String.valueOf(avg);
    }

    @GetMapping("avgGrassHP")
    public String averageGrassHP(){
        var avg = _services.avgGrassHPValue().get();
        return String.valueOf(avg);
    }

    @GetMapping("countAboveAvgHP")
    public String greaterThanAverageHpCount(){
        var avg = _services.avgHPCounter().count();
        return String.valueOf(avg);
    }

    @GetMapping("fastestAvgType")
    public String fastestType(){
        return _services.fastestAvgTypeValue().get();
    }

    private final IPokemonMeasureServices _services;
}

package kea.pokedexbackend.Controllers.Measurements;

import kea.pokedexbackend.Dbservices.MySql.Connectors.DbConnectionException;
import kea.pokedexbackend.models.Measurements.count.CountDetails;
import kea.pokedexbackend.utils.json.Generic.JSerializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
public class PokemonMeasurements {
    public PokemonMeasurements(IPokemonMeasureServices services) {_services = services;}

    @GetMapping("countTypes")
    public String countByPrimary(){
        List<CountDetails> counts;
        try {
            counts = _services.counter().count();
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        return JSerializer.serialize(counts);
    }

    @GetMapping("avgDef")
    public String averageDefence(){
        double avg;
        try {
            avg = _services.avgDefValue().get();
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        return String.valueOf(avg);
    }

    @GetMapping("avgGrassHP")
    public String averageGrassHP(){
        double avg;
        try {
            avg = _services.avgGrassHPValue().get();
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        return String.valueOf(avg);
    }

    @GetMapping("countAboveAvgHP")
    public String greaterThanAverageHpCount(){
        int avg;
        try {
            avg = _services.avgHPCounter().count();
        } catch (DbConnectionException e) {
            return e.getMessage();
        }
        return String.valueOf(avg);
    }

    @GetMapping("fastestAvgType")
    public String fastestType(){
        try {
            return _services.fastestAvgTypeValue().get();
        } catch (DbConnectionException e){
            return e.getMessage();
        }
    }

    private final IPokemonMeasureServices _services;
}

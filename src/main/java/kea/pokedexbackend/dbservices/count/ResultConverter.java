package kea.pokedexbackend.dbservices.count;

import kea.pokedexbackend.models.count.CountDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultConverter {
    public static List<CountDetails> ConvertAll(ResultSet set){
        var converter = new ResultConverter();
        try {
            return converter._convertAll(set);
        } catch (SQLException e) {
            return new ArrayList<>();
        }

    }

    private ResultConverter(){

    }

    private List<CountDetails> _convertAll(ResultSet set) throws SQLException {
        var counts = new ArrayList<CountDetails>();
        while (set.next()){
            var count = toCount(set);
            counts.add(count);
        }
        return counts;
    }

    private CountDetails toCount(ResultSet set) throws SQLException {
        var count = new CountDetails(){{
            type = set.getString("type");
            count = set.getInt("count");
        }};
        return count;
    }

}

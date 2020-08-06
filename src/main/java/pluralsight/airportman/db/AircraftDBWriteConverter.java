package pluralsight.airportman.db;

import org.springframework.core.convert.converter.Converter;
import pluralsight.airportman.domain.Aircraft;

import java.util.Arrays;
import java.util.List;

public class AircraftDBWriteConverter implements Converter<Aircraft, String> {

    public String convert(Aircraft source) {

        return source.getCode() + " - " + source.getNbSeats();
    }
}

package pluralsight.airportman.db;

import org.springframework.core.convert.converter.Converter;
import pluralsight.airportman.domain.Aircraft;

public class AircraftDBReadConverter implements Converter<String, Aircraft> {

    public Aircraft convert(String source) {

        String[] parts = source.split("-");
        Aircraft aircraft = new Aircraft(
                parts[0],
                Integer.parseInt(parts[1]));

        return aircraft;
    }
}

package pluralsight.airportman.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("aircraft")
public class Aircraft {

    @Indexed(unique = true)
    private String code;

    private int nbSeats;

    public Aircraft(String code, int nbSeats) {

        this.code = code;
        this.nbSeats = nbSeats;
    }

    public String getCode() {

        return code;
    }

    public int getNbSeats() {

        return nbSeats;
    }
}




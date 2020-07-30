package pluralsight.airportman.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Aircraft {
    @Id
    private  String id;

    @Indexed(unique = true)
    private String code;

    private String family;
    private int nbSeats;
    private Engine engine;
}

class Engine {
    private boolean isNeedsMaintainance;

    public Engine(boolean isNeedsMaintainance) {
        this.isNeedsMaintainance = isNeedsMaintainance;
    }

    public boolean isNeedsMaintainance() {
        return isNeedsMaintainance;
    }
}


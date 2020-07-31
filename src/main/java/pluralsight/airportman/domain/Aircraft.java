package pluralsight.airportman.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Aircraft {

  @Id
  private String id;

  @Indexed(unique = true)
  private String code;

  private String family;
  private int nbSeats;
  private Engine engine;

  public Aircraft(String id, int nbSeats) {

    this.id = id;
    this.nbSeats = nbSeats;
  }

  public String getId() {

    return id;
  }

  public String getCode() {

    return code;
  }

  public void setCode(String code) {

    this.code = code;
  }

  public String getFamily() {

    return family;
  }

  public void setFamily(String family) {

    this.family = family;
  }

  public int getNbSeats() {

    return nbSeats;
  }

  public Engine getEngine() {

    return engine;
  }

  public void setEngine(boolean isNeedsMaintenance) {
    Engine engine = new Engine(isNeedsMaintenance);
    this.engine = engine;
  }
}

class Engine {

  private final boolean isNeedsMaintenance;

  public Engine(boolean isNeedsMaintenance) {

    this.isNeedsMaintenance = isNeedsMaintenance;
  }

  public boolean isNeedsMaintenance() {

    return isNeedsMaintenance;
  }
}




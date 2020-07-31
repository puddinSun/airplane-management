package pluralsight.airportman;

import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import pluralsight.airportman.domain.Aircraft;
import pluralsight.airportman.domain.FlightInfo;
import pluralsight.airportman.domain.FlightType;
import pluralsight.airportman.queries.FlightInfoQuery;

@Component
public class ApplicationRunner implements CommandLineRunner {

  private MongoTemplate mongoTemplate;
  private FlightInfoQuery flightQuery;

  public ApplicationRunner(MongoTemplate mongoTemplate) {

    this.mongoTemplate = mongoTemplate;
    this.flightQuery = new FlightInfoQuery(mongoTemplate);
  }

  @Override
  public void run(String... args) throws Exception {

    if (this.flightQuery.countAll() == 0) {
      Aircraft aircraft1 = new Aircraft("1", 100);
      aircraft1.setCode("Bamboo01-CRH6");
      aircraft1.setFamily("Bamboo Airway");
      aircraft1.setEngine(false);
      FlightInfo flight1 = new FlightInfo();
      flight1.setAircraft(aircraft1);
      flight1.setType(FlightType.INTERNAL);
      flight1.setDepartureCity("Hanoi");
      flight1.setDestinationCity("Danang");
      flight1.setDelayed(false);
      flight1.setDepartureDate(LocalDate.now());
      flight1.setDurationMin(20);

      this.mongoTemplate.save(flight1);

      Aircraft aircraft2 = new Aircraft("2", 200);
      aircraft2.setCode("VNA-01-CR90");
      aircraft2.setFamily("Vietnam Airline");
      aircraft2.setEngine(false);

      FlightInfo flight2 = new FlightInfo();
      flight2.setAircraft(aircraft2);
      flight2.setType(FlightType.INTERNATIONAL);
      flight2.setDepartureCity("Hanoi");
      flight2.setDestinationCity("Japan");
      flight2.setDelayed(false);
      flight2.setDepartureDate(LocalDate.now());
      flight2.setDurationMin(80);

      this.mongoTemplate.save(flight2);
    }

    List<FlightInfo> flightCollection = this.flightQuery.findAll("departure", 0, 100);
    System.out.println("Collection size: " + flightCollection.size());
    for (FlightInfo document : flightCollection) {
      System.out.println(document.toString());
    }
  }
}

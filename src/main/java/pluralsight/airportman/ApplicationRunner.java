package pluralsight.airportman;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pluralsight.airportman.db.FlightInfoRepository;
import pluralsight.airportman.domain.Aircraft;
import pluralsight.airportman.domain.FlightInfo;
import pluralsight.airportman.domain.FlightType;

@Component
@Order(1)
public class ApplicationRunner implements CommandLineRunner {

  private FlightInfoRepository flightInfoRepository;

  public ApplicationRunner(FlightInfoRepository flightInfoRepository) {

    this.flightInfoRepository = flightInfoRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    this.clean();
    this.init();
  }

  public void clean() {

    this.flightInfoRepository.deleteAll();
  }

  public void init() {

    Aircraft aircraft1 = new Aircraft("Bamboo123", 100);
    Aircraft aircraft2 = new Aircraft("VN123", 200);

    FlightInfo flight1 = new FlightInfo("1");
    flight1.setAircraft(aircraft1);
    flight1.setType(FlightType.INTERNAL);
    flight1.setDepartureCity("Hanoi");
    flight1.setDestinationCity("Danang");
    flight1.setDelayed(false);
    flight1.setDepartureDate(LocalDate.now());
    flight1.setDurationMin(20);

    FlightInfo flight2 = new FlightInfo("2");
    flight2.setAircraft(aircraft2);
    flight2.setType(FlightType.INTERNATIONAL);
    flight2.setDepartureCity("Hanoi");
    flight2.setDestinationCity("Japan");
    flight2.setDelayed(false);
    flight2.setDepartureDate(LocalDate.now());
    flight2.setDurationMin(80);

    this.flightInfoRepository.insert(flight1);
    this.flightInfoRepository.save(flight2);
  }

}

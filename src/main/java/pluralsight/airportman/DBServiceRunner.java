package pluralsight.airportman;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pluralsight.airportman.db.FlightInfoRepository;
import pluralsight.airportman.domain.FlightInfo;

@Component
@Order(2)
public class DBServiceRunner implements CommandLineRunner {

  private FlightInfoRepository flightInfoRepository;

  public DBServiceRunner(FlightInfoRepository flightInfoRepository) {

    this.flightInfoRepository = flightInfoRepository;
  }

  public void run(String... args) throws Exception {

    this.markAllFlightToJapanAsDelayed();
    this.removeFlightsWithDurationLessThan60Minutes();
  }

  public void markAllFlightToJapanAsDelayed() {

    List<FlightInfo> flightInfos = this.flightInfoRepository.findByDestinationCityIs("Japan");
    for (FlightInfo flightInfo : flightInfos) {
      flightInfo.setDelayed(true);
      this.flightInfoRepository.save(flightInfo);
    }

  }

  public void removeFlightsWithDurationLessThan60Minutes() {

    List<FlightInfo> flightInfo =
        this.flightInfoRepository.findByDurationMinLessThanEqual(0);

    for (FlightInfo entity : flightInfo) {
      this.flightInfoRepository.delete(entity);
    }

  }
}

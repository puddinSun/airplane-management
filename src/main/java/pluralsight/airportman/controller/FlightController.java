package pluralsight.airportman.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pluralsight.airportman.domain.FlightInfo;
import pluralsight.airportman.queries.FlightInfoQuery;

@RestController
public class FlightController {

  private FlightInfoQuery query;

  public FlightController(FlightInfoQuery query) {

    this.query = query;
  }

  @GetMapping(value = "/flights", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<FlightInfo> getAll() {
    return this.query.findAll("departure", 0, 20);
  }
}

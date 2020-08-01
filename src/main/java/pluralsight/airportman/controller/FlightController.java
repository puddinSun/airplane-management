package pluralsight.airportman.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pluralsight.airportman.domain.FlightInfo;
import pluralsight.airportman.queries.FlightInfoQuery;

@RestController
public class FlightController {

    private FlightInfoQuery query;

    public FlightController(FlightInfoQuery query) {

        this.query = query;
    }

    @GetMapping(value = "/flights/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<FlightInfo> getAll() {
        return this.query.findAll("departure", 0, 20);
    }

    @GetMapping(value = "/flight")
    @ResponseBody
    public FlightInfo findById(@RequestParam("id") String id) {
        return this.query.findById(id);
    }

    @GetMapping(value = "/flights/duration")
    @ResponseBody
    public List<FlightInfo> findByDurationBetween(
            @RequestParam("min") int durationMin,
            @RequestParam("max") int durationMax) {
        return this.query.findByDurationBetween(durationMin, durationMax);
    }

    @GetMapping(value = "/flights/delayed")
    @ResponseBody
    public List<FlightInfo> findDelayedByDeparture(
            @RequestParam("departure") String departure) {
        return this.query.findDelayedByDeparture(departure);
    }

    @GetMapping(value = "/flights/ontime")
    @ResponseBody
    public List<FlightInfo> findNotDelayedByCity(
            @RequestParam("destination") String destinationCity) {
        return this.query.findNotDelayedByCity(destinationCity);
    }

    @GetMapping(value = "/flights")
    @ResponseBody
    public List<FlightInfo> findByAircraftModel(
            @RequestParam("code") String code) {
        return this.query.findByAircraftModel(code);
    }
}

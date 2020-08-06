package pluralsight.airportman.queries;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import pluralsight.airportman.domain.FlightInfo;
import pluralsight.airportman.domain.FlightType;

import java.util.List;

@Service
public class FlightInfoQuery {

  private MongoTemplate mongoTemplate;

  public FlightInfoQuery(MongoTemplate mongoTemplate) {

    this.mongoTemplate = mongoTemplate;
  }

  public long countAll() {

    return this.mongoTemplate.count(new Query(), FlightInfo.class);
  }

  // 1. Find all flight with paging and sorting
  public List<FlightInfo> findAll(String filed, int pageNumber, int pageSize) {

    Query allPageAndOrdered = new Query()
        .with(Sort.by(Direction.DESC, filed))
        .with(PageRequest.of(pageNumber, pageSize));

    return this.mongoTemplate.find(allPageAndOrdered, FlightInfo.class);
  }

  // 2. Find the flight by ID
  public FlightInfo findById(String id) {

    return this.mongoTemplate.findById(id, FlightInfo.class);
  }

  // 3. Count all international flights
  public long countInternationalFlights() {

    Query findInternationalFlight = Query.query(Criteria.where("type")
        .is(FlightType.INTERNATIONAL));

    return this.mongoTemplate.count(findInternationalFlight, FlightInfo.class);
  }

  // 4. Find all flight by departure city
  public List<FlightInfo> findByDepartureCity(String departure) {

    Query findInternationalFlight = Query.query(
        Criteria.where("departure").is(departure));

    return this.mongoTemplate.find(findInternationalFlight, FlightInfo.class);
  }

  // 5. Find all flight by duration between min and max
  public List<FlightInfo> findByDurationBetween(int durationMin, int durationMax) {

    Query findDurationBetween = Query.query(
        Criteria.where("durationMin")
            .gte(durationMin)
            .lte(durationMax))
        .with(Sort.by(Direction.DESC, "durationMin"));

    return this.mongoTemplate.find(findDurationBetween, FlightInfo.class);
  }

  // 6. Find all flight delayed at a particular departure city
  public List<FlightInfo> findDelayedByDeparture(String departure) {

    Query findDelayByDeparture = Query.query(Criteria
        .where("departure").is(departure)
        .and("isDelayed").is(true));

    return this.mongoTemplate.find(findDelayByDeparture, FlightInfo.class);
  }

  // 7. Find all flight that are on time and relate to a city
  public List<FlightInfo> findNotDelayedByCity(String city) {

    Query findNotDelayedAndRelateToCity = Query.query(
        new Criteria()
            .orOperator(
                Criteria.where("departure").is(city),
                Criteria.where("destination").is(city))
            .andOperator(Criteria.where("isDelayed").is(false)));

    return this.mongoTemplate.find(findNotDelayedAndRelateToCity, FlightInfo.class);
  }

  // 8. Find by aircraft model
  public List<FlightInfo> findByAircraftModel(String code) {

    Query findByAircraftModel = Query.query(Criteria
        .where("aircraft.code").is(code));

    return this.mongoTemplate.find(findByAircraftModel, FlightInfo.class);
  }
}
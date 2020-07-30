package pluralsight.airportman.queries;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class FlightInfoQuery {
    private MongoTemplate mongoTemplate;

    public FlightInfoQuery(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * TODO: implement all the following queries
     *  1. Find all flight with paging and sorting
     *  2. Find the flight by ID
     *  3. Count all international flights
     *  4. Find all flight by departure city
     *  5. Find all flight by duration between min and max
     *  6. Find all flight delayed at a particular departure city
     *  7. Find all flight that are on time and relate to a city
     *  8. Find by aircraft model
     */
}

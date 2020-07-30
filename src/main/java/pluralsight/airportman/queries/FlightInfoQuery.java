package pluralsight.airportman.queries;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class FlightInfoQuery {
    private MongoTemplate mongoTemplate;

    public FlightInfoQuery(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    
}

package pluralsight.airportman;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import pluralsight.airportman.domain.FlightInfo;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private MongoTemplate mongoTemplate;

    public ApplicationRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        FlightInfo flight = new FlightInfo();
        this.mongoTemplate.save(flight);

        System.out.println("Application started ...");
    }
}

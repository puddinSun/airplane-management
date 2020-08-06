package pluralsight.airportman.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pluralsight.airportman.domain.FlightInfo;

import java.util.List;

@Repository
public interface FlightInfoRepository extends MongoRepository<FlightInfo, String> {

    List<FlightInfo> findByDestinationCityIs(String destination);
    List<FlightInfo> findByDurationMinLessThanEqual(int minutes);
}

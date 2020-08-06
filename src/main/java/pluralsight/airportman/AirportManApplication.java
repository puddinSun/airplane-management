package pluralsight.airportman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import pluralsight.airportman.db.AircraftDBReadConverter;
import pluralsight.airportman.db.AircraftDBWriteConverter;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AirportManApplication {

  public static void main(String[] args) {

    SpringApplication.run(AirportManApplication.class, args);
  }

  @Bean
  public MongoCustomConversions customConversions() {

    List<Converter<?, ?>> converters = new ArrayList<>();
//    converters.add(new AircraftDBReadConverter());
//    converters.add(new AircraftDBWriteConverter());

    return new MongoCustomConversions(converters);
  }
}

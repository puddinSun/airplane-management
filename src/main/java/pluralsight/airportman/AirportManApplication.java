package pluralsight.airportman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AirportManApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportManApplication.class, args);
	}

	@GetMapping("/getAircraft")
	public static String getAircraft() {
        return "aircraft ...";
    }
}

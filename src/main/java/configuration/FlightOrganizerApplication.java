package configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class})
class FlightOrganizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightOrganizerApplication.class, args);
	}

}

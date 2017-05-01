package configuration;

import flight.Flight;
import flight.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "flight")
@EntityScan("flight")
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class})
public class FlightOrganizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightOrganizerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(FlightRepository flightRepository){
		return args -> {
			flightRepository.save(new Flight("Warsow" , "Cracow"));
			flightRepository.save(new Flight("Cracow" , "Warsow"));
			flightRepository.save(new Flight("Barcelona" , "Warsow"));
		};
	}
}

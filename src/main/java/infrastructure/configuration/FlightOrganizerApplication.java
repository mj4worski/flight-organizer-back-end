package infrastructure.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"flight" , "client"} )
@EntityScan(basePackages = {"flight", "client"})
@ComponentScan(basePackages = {"rest" , "flight" ,"client" , "infrastructure"})
public class FlightOrganizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightOrganizerApplication.class, args);
	}

}

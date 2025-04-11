package pharmacymanagment.pharmacy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PharmacyApplication {

private final Logger LOGGER = LoggerFactory.getLogger(PharmacyApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(PharmacyApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			LOGGER.info("Application Started");
		};
	}
}

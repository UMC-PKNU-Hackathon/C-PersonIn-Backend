package umc.coffeein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoffeeinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeinApplication.class, args);
	}

}

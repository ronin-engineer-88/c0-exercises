package src;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ELearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELearnApplication.class, args);
	}

}

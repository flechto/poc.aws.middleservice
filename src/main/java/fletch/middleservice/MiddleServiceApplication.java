package fletch.middleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableSqs
public class MiddleServiceApplication {

	public static void main(String[] args) {

	    SpringApplication.run(MiddleServiceApplication.class, args);
	}
}

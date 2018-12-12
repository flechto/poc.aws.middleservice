package fletch.middleservice;

import com.amazonaws.services.sns.AmazonSNS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSns;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableSqs
@EnableSns
public class MiddleServiceApplication {

	public static void main(String[] args) {

	    SpringApplication.run(MiddleServiceApplication.class, args);
	}

	@Bean
	public NotificationMessagingTemplate snsTemplate(AmazonSNS amazonSNS) {

		return new NotificationMessagingTemplate(amazonSNS);
	}
}

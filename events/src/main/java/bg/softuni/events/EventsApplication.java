package bg.softuni.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class EventsApplication {

	public static void main(String[] args) {

		SpringApplication springApp = new SpringApplication
				(EventsApplication.class);
		springApp.run(args);
	}

}

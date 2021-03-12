package bg.softuni.events.transactions;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BirdEventPublisher {

  private final ApplicationEventPublisher applicationEventPublisher;

  public BirdEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public void publishEvent(String breed) {
    BirdEvent event = new BirdEvent(breed);
    applicationEventPublisher.publishEvent(event);
  }

}

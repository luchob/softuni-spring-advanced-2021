package bg.softuni.events.custom;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class StudentEventPublisher {

  private final ApplicationEventPublisher applicationEventPublisher;

  public StudentEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public void publishEvent(String name, double grade) {
    StudentEvent event = new StudentEvent(name, grade);
    applicationEventPublisher.publishEvent(event);
  }
}

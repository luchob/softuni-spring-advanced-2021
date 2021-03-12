package bg.softuni.events.transactions;

import org.springframework.context.ApplicationEvent;

public class BirdEvent extends ApplicationEvent {

  private final String breed;

  public BirdEvent(String breed) {
    super(breed);
    this.breed = breed;
  }

  public String getBreed() {
    return breed;
  }
}

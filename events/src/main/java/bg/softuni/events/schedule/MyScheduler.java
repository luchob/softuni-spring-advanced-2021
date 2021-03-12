package bg.softuni.events.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class MyScheduler {

  @Scheduled(fixedRate = 3000)
  public void fixedRate() {
    System.out.println("I'm executing on every 3000 millis! If I last more than 3000 millis the next won't wait!");
  }

  @Scheduled(fixedDelay = 3000)
  public void fixedDelay() {
    System.out.println("I'm executing on every 3000 millis! If I last more than 3000 the next will wait");
  }

  @Scheduled(cron = "*/1 * * * * *")
  public void onEachSecond() {
    System.out.println("Tic tac");
  }

}

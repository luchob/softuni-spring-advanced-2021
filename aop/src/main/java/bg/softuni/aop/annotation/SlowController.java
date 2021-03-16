package bg.softuni.aop.annotation;

import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlowController {

  @TrackLatency(latency = "operation1")
  @GetMapping("/operation1")
  public String operation1() {
    return "operation1";
  }

  @TrackLatency(latency = "operation2")
  @GetMapping("/operation2")
  public String operation2() {
    try {
      Thread.sleep(new Random().nextInt(1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "operation2";
  }

}

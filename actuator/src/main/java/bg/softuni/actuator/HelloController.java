package bg.softuni.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private final HelloBean helloBean;
  private final Counter helloCounter;

  public HelloController(HelloBean helloBean,
      MeterRegistry meterRegistry) {
    this.helloBean = helloBean;
    helloCounter = Counter.
        builder("softuni.hello").
        description("How many times we have said hello?").
        register(meterRegistry);
  }

  @GetMapping("/hello")
  public String hello() {
    helloCounter.increment();
    helloBean.sayHello();
    return "Hello!";
  }

}

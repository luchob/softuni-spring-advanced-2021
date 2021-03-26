package bg.softuni.docker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private final String message;

  public HelloController(@Value("${test.message}") String message) {

    this.message = message;
  }

  @GetMapping("/hello")
  public String hello() {
    return this.message;
  }

}

package bg.softuni.errors.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Error400Controller {

  @GetMapping("/exception-response-status")
  public void throwCustomException() throws Error400Exception {
    throw new Error400Exception("This is a custom exception...");
  }

  @GetMapping("/exception-general")
  public void throwRuntimeException() {
    throw new RuntimeException("This is a runtime exception...");
  }
}

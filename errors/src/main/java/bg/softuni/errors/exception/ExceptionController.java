package bg.softuni.errors.exception;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

  @GetMapping("/exception-response-status")
  public void throwExceptionWithResponseStatus() throws Error400Exception {
    throw new Error400Exception("Exception endpoint triggered!");
  }

  @GetMapping("/exception")
  public void throwException() {
    throw new RuntimeException("Runtime exception!");
  }

}

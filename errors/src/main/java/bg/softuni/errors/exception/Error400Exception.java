package bg.softuni.errors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
    code = HttpStatus.BAD_REQUEST,
    reason = "Client mistake."
)
public class Error400Exception extends Exception {

  public Error400Exception(String message) {
    super(message);
  }
}

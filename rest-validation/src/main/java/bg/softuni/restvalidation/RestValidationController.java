package bg.softuni.restvalidation;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestValidationController {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(RestValidationController.class);

  @PostMapping("/post")
  public ResponseEntity<RestValidationServiceModel> post(@Valid @RequestBody RestValidationServiceModel model) {
    LOGGER.info("Model = [{}].", model);
    return ResponseEntity.ok().build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ObjectError> handleValidationExceptions(MethodArgumentNotValidException ex) {

    BindingResult bindingResult = ex.getBindingResult();
    return bindingResult.getAllErrors();
  }

}

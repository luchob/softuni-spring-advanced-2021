package bg.softuni.restvalidation;

import java.util.List;
import javax.validation.Valid;
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
public class SampleRestController {

  @PostMapping("/post")
  public ResponseEntity<PersonModel> save(@Valid @RequestBody PersonModel personModel) {
    System.out.println(personModel);
    return ResponseEntity.ok().build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ObjectError> handleException(MethodArgumentNotValidException exception) {
    BindingResult bindingResult = exception.getBindingResult();
    return bindingResult.getAllErrors();
  }

}

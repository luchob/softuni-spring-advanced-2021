package bg.softuni.errors.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandlerControllerRest {

  @GetMapping("/student")
  public Student getStudent() {
    // ... searching for the student
    throw new StudentNotFoundException("Sorry, not student");
  }

  @GetMapping("/student-ex")
  public Student getStudentEx() {
    throw new IllegalArgumentException("Sorry, booom!");
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler({StudentNotFoundException.class})
  public Student handleException() {
    return new Student().setName("Default Pesho");
  }
}

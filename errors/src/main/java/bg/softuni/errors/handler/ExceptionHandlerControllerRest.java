package bg.softuni.errors.handler;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandlerControllerRest {

  @GetMapping("/student")
  public ResponseEntity<Student> getStudent() {
    throw new StudentNotFoundException();
  }

  @ExceptionHandler({StudentNotFoundException.class})
  public ResponseEntity<Student> handleDbExceptions(StudentNotFoundException e) {
    return ResponseEntity.ok(new Student().setName("Default student"));
  }

//  @ResponseStatus(value= HttpStatus.NOT_FOUND,
//      reason="Student not found!")
//  @ExceptionHandler(StudentNotFoundException.class)
//  public void notFound() {
//    // Nothing to do
//  }


  public static class Student {
    private String name;

    public String getName() {
      return name;
    }

    public Student setName(String name) {
      this.name = name;
      return this;
    }
  }
}

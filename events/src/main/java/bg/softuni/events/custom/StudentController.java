package bg.softuni.events.custom;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  private final StudentEventPublisher publisher;

  public StudentController(StudentEventPublisher publisher) {

    this.publisher = publisher;
  }

  @GetMapping("/custom-event")
  public ResponseEntity<String> publishEvent() {
    publisher.publishEvent("Pesho", 3);
    publisher.publishEvent("Anna", 6);
    return ResponseEntity.ok().build();
  }

}

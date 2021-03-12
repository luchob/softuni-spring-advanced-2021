package bg.softuni.events.cache;

import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

  private final StudentService studentService;

  public StudentRestController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/students")
  public List<Student> findAllStudents() {
    return studentService.findAllStudents();
  }

  @GetMapping("/students-purge")
  public List<Student> purgeStudents() {
    studentService.purgeCache();
    return Collections.emptyList();
  }

}

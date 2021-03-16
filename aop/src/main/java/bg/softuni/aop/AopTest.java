package bg.softuni.aop;

import bg.softuni.aop.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AopTest implements CommandLineRunner {

  private final Student student;

  public AopTest(Student student) {
    this.student = student;
  }

  @Override
  public void run(String... args) throws Exception {
    student.echo("Hello, world!");
  }
}

package bg.softuni.hateoas;

import bg.softuni.hateoas.model.entity.Course;
import bg.softuni.hateoas.model.entity.Student;
import bg.softuni.hateoas.repository.CourseRepository;
import bg.softuni.hateoas.repository.OrderRepository;
import bg.softuni.hateoas.repository.StudentRepository;
import bg.softuni.hateoas.model.entity.Order;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HateoasApplicationInit implements CommandLineRunner {

  private final StudentRepository studentRepository;
  private final CourseRepository courseRepository;
  private final OrderRepository orderRepository;

  HateoasApplicationInit(StudentRepository studentRepository,
      CourseRepository courseRepository,
      OrderRepository orderRepository) {

    this.studentRepository = studentRepository;
    this.courseRepository = courseRepository;
    this.orderRepository = orderRepository;
  }

  @Override
  public void run(String... args) {

    if (courseRepository.count() == 0 &&
        studentRepository.count() == 0 &&
        orderRepository.count() == 0) {

      Student pavel = new Student();
      pavel.setName("Pavel Ivanov");
      pavel.setAge(22);

      pavel = studentRepository.save(pavel);

      Course springAdvanced = new Course();
      springAdvanced.setName("Spring Advanced");
      springAdvanced.setPrice(BigDecimal.valueOf(100.0));
      springAdvanced.setEnabled(true);

      springAdvanced = courseRepository.save(springAdvanced);

      Course springBasic = new Course();
      springBasic.setName("Spring Fundamentals");
      springBasic.setPrice(BigDecimal.valueOf(100.0));
      springBasic.setEnabled(false);

      courseRepository.save(springBasic);

      Order pavelSpring = new Order();
      pavelSpring.setCourse(springAdvanced);
      pavelSpring.setStudent(pavel);

      orderRepository.save(pavelSpring);
    }
  }
}

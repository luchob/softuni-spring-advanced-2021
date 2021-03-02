package bg.softuni.hateoas.web;

import bg.softuni.hateoas.model.entity.Course;
import bg.softuni.hateoas.model.entity.Order;
import bg.softuni.hateoas.model.view.OrderViewModel;
import bg.softuni.hateoas.model.entity.Student;
import bg.softuni.hateoas.repository.CourseRepository;
import bg.softuni.hateoas.repository.OrderRepository;
import bg.softuni.hateoas.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/orders")
public class OrdersController {

  @PostMapping
  public ResponseEntity<OrderViewModel> enroll(OrderViewModel orderViewModel) {
    //TODO: Create new order
    //TODO: check if the course is enabled!
    return ResponseEntity.ok().build();
  }
}

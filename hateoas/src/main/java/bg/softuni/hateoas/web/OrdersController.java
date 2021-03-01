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

    private final OrderRepository orderRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public OrdersController(OrderRepository orderRepository,
        StudentRepository studentRepository,
        CourseRepository courseRepository) {
        this.orderRepository = orderRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<OrderViewModel>>> getOrders() {
       List<Order> orders =
           this.orderRepository.findAll();
       List<EntityModel<OrderViewModel>> orderDTOs = orders.
           stream().
           map(OrderViewModel::asDTO).
           map(dto -> EntityModel.of(dto, buildOrderLinks(dto))).
           collect(Collectors.toList());

       return ResponseEntity.ok(CollectionModel.of(
           orderDTOs,
           linkTo(methodOn(OrdersController.class).getOrders()).withSelfRel()
       ));
    }

    @PostMapping
    public ResponseEntity<EntityModel<OrderViewModel>> enroll(@RequestBody OrderViewModel orderViewModel) {
        // TODO: Error handling, service layer
        Student student = studentRepository.getOne(orderViewModel.getStudentId());
        Course course = courseRepository.getOne(orderViewModel.getCourseId());

        Order newOrder = new Order();
        newOrder.setStudent(student);
        newOrder.setCourse(course);

        Order savedOrder = this.orderRepository.save(newOrder);
        OrderViewModel savedOrderViewModel = OrderViewModel.asDTO(savedOrder);
        buildOrderLinks(savedOrderViewModel);

        return ResponseEntity.ok(EntityModel.of(savedOrderViewModel,
            buildOrderLinks(savedOrderViewModel)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<OrderViewModel>> getOrder(@PathVariable("id") Long id) {

        Optional<Order> orderOpt = this.orderRepository.findById(id);

        return orderOpt.
            map(OrderViewModel::asDTO).
            map(dto -> EntityModel.of(dto, buildOrderLinks(dto))).
            map(ResponseEntity::ok).
            orElse(ResponseEntity.notFound().build());
    }

    private Link[] buildOrderLinks(OrderViewModel order) {

        Link self = linkTo(methodOn(OrdersController.class)
            .getOrder(order.getId()))
            .withSelfRel();

        Link course = linkTo(methodOn(CoursesController.class)
            .getCourse(order.getCourseId()))
            .withRel("course");

        Link student = linkTo(methodOn(StudentsController.class)
            .getStudent(order.getStudentId()))
            .withRel("student");

        return List.of(self, course, student).toArray(new Link[0]);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EntityModel<OrderViewModel>> delete(@PathVariable("id") Long id) {
        this.orderRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}

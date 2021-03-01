package bg.softuni.hateoas.web;

import bg.softuni.hateoas.model.view.OrderViewModel;
import bg.softuni.hateoas.model.entity.Student;
import bg.softuni.hateoas.model.view.StudentViewModel;
import bg.softuni.hateoas.repository.OrderRepository;
import bg.softuni.hateoas.repository.StudentRepository;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/students")
public class StudentsController {

  private final StudentRepository studentRepository;
  private final OrderRepository orderRepository;
  private final ModelMapper mapper;

  public StudentsController(StudentRepository studentRepository,
      OrderRepository orderRepository,
      ModelMapper mapper) {

    this.mapper = mapper;
    this.studentRepository = studentRepository;
    this.orderRepository = orderRepository;
  }

  @GetMapping("/{id}")
  public ResponseEntity<EntityModel<StudentViewModel>> getStudent(@PathVariable(name = "id")
      Long id) {

    Optional<StudentViewModel> studentOpt = this.studentRepository.
        findById(id).
        map(s -> mapper.map(s, StudentViewModel.class));

    return studentOpt.
        map(s -> ResponseEntity.ok(EntityModel.of(s, getStudentLinks(s)))).
        orElse(ResponseEntity.notFound().build());
  }

  private Link[] getStudentLinks(StudentViewModel student) {
    Link self = linkTo(methodOn(StudentsController.class)
        .getStudent(student.getId()))
        .withSelfRel();

    Link orders = linkTo(methodOn(StudentsController.class).getAllOrdersByStudentId(student.getId()))
        .withRel("orders");

    return List.of(self, orders).toArray(new Link[0]);
  }

  @GetMapping("/{id}/orders")
  public ResponseEntity<CollectionModel<EntityModel<OrderViewModel>>> getAllOrdersByStudentId(@PathVariable(name = "id")
      Long studentId) {
    List<EntityModel<OrderViewModel>> orders =
        orderRepository.findAllByStudentId(studentId).
            stream().
            map(OrderViewModel::asDTO).
            map(
                dto -> EntityModel.of(dto,
                    linkTo(methodOn(OrdersController.class).getOrder(dto.getId())).withSelfRel())
            ).
            collect(Collectors.toList());

    return ResponseEntity.ok(
        CollectionModel.of(orders,
            linkTo(methodOn(StudentsController.class).getAllOrdersByStudentId(studentId)).withSelfRel()));
  }

  @GetMapping
  public ResponseEntity<CollectionModel<EntityModel<StudentViewModel>>> getAllStudents() {
    List<EntityModel<StudentViewModel>> all = this.studentRepository
        .findAll().
            stream().
            map(s -> mapper.map(s, StudentViewModel.class)).
            map(s -> EntityModel.of(s, getStudentLinks(s))).
            collect(Collectors.toList());

    return ResponseEntity.ok(
        CollectionModel.of(all,
            linkTo(methodOn(StudentsController.class).getAllStudents()).withSelfRel()));
  }

}

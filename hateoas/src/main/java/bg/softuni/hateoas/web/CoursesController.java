package bg.softuni.hateoas.web;

import bg.softuni.hateoas.model.entity.Course;
import bg.softuni.hateoas.model.view.CourseViewModel;
import bg.softuni.hateoas.model.view.OrderViewModel;
import bg.softuni.hateoas.repository.CourseRepository;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/courses")
public class CoursesController {

  private final CourseRepository courseRepository;
  private final ModelMapper mapper;

  @Autowired
  public CoursesController(CourseRepository courseRepository,
      ModelMapper mapper) {
    this.courseRepository = courseRepository;
    this.mapper = mapper;
  }

  @GetMapping
  public ResponseEntity<CollectionModel<EntityModel<CourseViewModel>>> getAllCourses() {

    List<EntityModel<CourseViewModel>> courses = courseRepository.findAll().stream()
        .map(course -> mapper.map(course, CourseViewModel.class))
        .map(courseModel -> EntityModel.of(courseModel, createCourseLinks(courseModel)))
        .collect(Collectors.toList());

    return ResponseEntity.ok(
        CollectionModel.of(courses,
            linkTo(methodOn(CoursesController.class).getAllCourses()).withSelfRel()));
  }


  @GetMapping("/{id}")
  public ResponseEntity<EntityModel<CourseViewModel>> getCourse(@PathVariable("id") Long id) {

    Optional<CourseViewModel> courseOpt = this.courseRepository
        .findById(id).map(course -> mapper.map(course, CourseViewModel.class));

    return courseOpt.
        map(
            c -> EntityModel.of(c, createCourseLinks(c))
        ).map(ResponseEntity::ok).
        orElse(ResponseEntity.notFound().build());
  }

  private Link[] createCourseLinks(CourseViewModel course) {

    List<Link> result = new ArrayList<>();

    Link self = linkTo(methodOn(CoursesController.class)
        .getCourse(course.getId()))
        .withSelfRel();
    result.add(self);

    if (course.isEnabled()) {

      Link enroll = linkTo(methodOn(OrdersController.class).
          enroll(new OrderViewModel().setCourseId(course.getId()))).
          withRel("enroll");

      result.add(enroll);
    }

    return result.toArray(new Link[0]);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Course> delete(@PathVariable("id") Long id) {

    this.courseRepository.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}

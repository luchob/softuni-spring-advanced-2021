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
  private final ModelMapper modelMapper;

  public CoursesController(CourseRepository courseRepository,
      ModelMapper modelMapper) {

    this.courseRepository = courseRepository;
    this.modelMapper = modelMapper;
  }

  @GetMapping
  public ResponseEntity<CollectionModel<EntityModel<CourseViewModel>>> getAllCourses() {
    List<EntityModel<CourseViewModel>> courses = courseRepository.
        findAll().
        stream().
        map(ce -> modelMapper.map(ce, CourseViewModel.class)).
        map(cv -> EntityModel.of(cv, createCourseLinks(cv))).
        collect(Collectors.toList());

    return ResponseEntity.ok(
        CollectionModel.of(courses,
            linkTo(methodOn(CoursesController.class).
                getAllCourses()).withSelfRel())
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<EntityModel<CourseViewModel>> getCourseById(@PathVariable Long id) {
    CourseViewModel courseViewModel = courseRepository.findById(id).
        map(ce -> modelMapper.map(ce, CourseViewModel.class)).
        orElseThrow();
    return ResponseEntity.ok(
        EntityModel.of(courseViewModel, createCourseLinks(courseViewModel))
    );
  }


  private Link[] createCourseLinks(CourseViewModel model) {
    List<Link> result = new ArrayList<>();

    Link selfLink = linkTo(methodOn(CoursesController.class).
        getCourseById(model.getId())).withSelfRel();
    result.add(selfLink);

    if (model.isEnabled()) {
      Link enrollLink = linkTo(methodOn(OrdersController.class).
          enroll(
              new OrderViewModel().setCourseId(model.getId()))).
          withRel("enroll");
      result.add(enrollLink);
    }

    return result.toArray(new Link[0]);
  }
}

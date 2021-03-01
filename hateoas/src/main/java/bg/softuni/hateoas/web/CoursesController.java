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
  //TODO:
}

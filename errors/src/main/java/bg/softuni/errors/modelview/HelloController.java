package bg.softuni.errors.modelview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

  @GetMapping("/hello")
  public ModelAndView normalHello(ModelAndView model) {
    model.setViewName("/hello");
    return model;
  }

  @GetMapping("/hello-ex")
  public ModelAndView exceptionalHello() {
    throw new RuntimeException("Something got terribly wrong!");
  }

  @GetMapping("/hello-ex-custom")
  public ModelAndView moreSpecificHello() {
    throw new HelloException("Hello!");
  }

}

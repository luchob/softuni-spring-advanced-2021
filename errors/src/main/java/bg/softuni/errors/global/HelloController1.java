package bg.softuni.errors.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController1 {

  @GetMapping("/hello")
  public ModelAndView hello(ModelAndView model) {
    model.setViewName("hello");
    return model;
  }

  @GetMapping("/hello-ex")
  public ModelAndView generalException() {
    throw new NullPointerException("NPEEEEEE!");
  }

  @GetMapping("/hello-ex-custom")
  public ModelAndView customException() {
    throw new HelloException("HELLO from Controller 1!");
  }

}

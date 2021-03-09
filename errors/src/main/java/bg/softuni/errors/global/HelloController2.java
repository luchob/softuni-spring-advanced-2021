package bg.softuni.errors.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController2 {

  @GetMapping("/hello2-ex-custom")
  public ModelAndView customException() {
    throw new HelloException("HELLO fro Controller 2!");
  }

}

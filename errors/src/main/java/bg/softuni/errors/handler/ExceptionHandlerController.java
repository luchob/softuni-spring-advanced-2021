package bg.softuni.errors.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionHandlerController {

  @GetMapping("/check-database")
  public ModelAndView checkDatabase() {
    // perform super complicated checks!
    // oops, we found that something is wrong
    throw new DBInconsistentException("The database is not in consistent state");
  }

  @GetMapping("/crash")
  public ModelAndView crash() {
    throw new RuntimeException("Uuups, we crashed.");
  }

  @ExceptionHandler({DBInconsistentException.class})
  public ModelAndView handleDBInconsistentException(DBInconsistentException ex) {
    ModelAndView modelAndView = new ModelAndView("handler");
    modelAndView.addObject("message", ex.getMessage());
    return modelAndView;
  }
}

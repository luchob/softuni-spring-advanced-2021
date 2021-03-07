package bg.softuni.errors.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionHandlerController {

  @GetMapping("/check-db")
  public ModelAndView checkDBStatus() {
    //some checks here
    throw new DBInconsistentException("DB is not in a consistent state!");
  }

  @GetMapping("/crash")
  public ModelAndView crash() {
    throw new RuntimeException("Crashed");
  }

  @ExceptionHandler({DBInconsistentException.class})
  public ModelAndView handleDbExceptions(DBInconsistentException e) {

    ModelAndView modelAndView = new ModelAndView("handler");
    modelAndView.addObject("message", e.getMessage());
    return modelAndView;

  }
}

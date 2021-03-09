package bg.softuni.errors.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalAdvise {

  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalAdvise.class);

  @ExceptionHandler({HelloException.class})
  public ModelAndView handleHelloException(HelloException exception) {
    LOGGER.error("Exception caught", exception);

      return new ModelAndView("hello-ex");
  }

}

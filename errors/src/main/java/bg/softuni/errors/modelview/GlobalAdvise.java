package bg.softuni.errors.modelview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalAdvise {

  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalAdvise.class);

  @ExceptionHandler({HelloException.class})
  public ModelAndView handleHelloExceptions(HelloException helloException) {

    LOGGER.error("Exception caught", helloException);

    ModelAndView result = new ModelAndView();
    result.setViewName("hello-ex");
    return result;
  }

}

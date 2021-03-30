package bg.softuni.interceptor.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

  private Logger LOGGER = LoggerFactory.getLogger(BusinessController.class);

  @GetMapping("/test")
  public ResponseEntity<String> test() {

    LOGGER.info("LOG1");
    LOGGER.info("LOG2");
    LOGGER.info("LOG3");
    LOGGER.info("LOG4");
    LOGGER.info("LOG5");
    LOGGER.info("LOG6");
    LOGGER.info("LOG7");
    LOGGER.info("LOG8");
    LOGGER.info("LOG9");
    LOGGER.info("LOG10");

    return ResponseEntity.ok().build();

  }

}

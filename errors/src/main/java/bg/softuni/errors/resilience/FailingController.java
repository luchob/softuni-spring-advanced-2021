package bg.softuni.errors.resilience;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FailingController {

  private static final Logger LOGGER = LoggerFactory.getLogger(FailingController.class);

  private final FailingService failingService;

  public FailingController(FailingService failingService) {
    this.failingService = failingService;
  }

  @GetMapping("/fail")
  public ResponseEntity<String> fail() {
    LOGGER.info("In controller... Calls so far: {}", failingService.getNumberOfCalls());
    this.failingService.fail();
    return ResponseEntity.ok().build();
  }

}

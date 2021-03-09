package bg.softuni.errors.resilience;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FailingController {

  private static final Logger LOGGER = LoggerFactory.getLogger(FailingService.class);

  private final FailingService failingService;

  FailingController(FailingService failingService) {
    this.failingService = failingService;
  }

  @GetMapping("/fail")
  public void fail() {
    LOGGER.info("I'm the failing controller. Count invocation before fail {}", failingService.getNumberOfCalls());
    failingService.fail();
    LOGGER.info("I'm the failing controller. Count invocation after fail {}", failingService.getNumberOfCalls());
  }

}

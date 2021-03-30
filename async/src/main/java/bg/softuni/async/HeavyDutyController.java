package bg.softuni.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeavyDutyController {

  private static Logger LOGGER = LoggerFactory.getLogger(HeavyDutyController.class);
  private final HeavyDutyService heavyDutyService;


  public HeavyDutyController(HeavyDutyService heavyDutyService) {
    this.heavyDutyService = heavyDutyService;
  }


  @GetMapping("/test")
  public ResponseEntity<String> test() {
    LOGGER.info("Start in controller");

    heavyDutyService.doWork();

    LOGGER.info("End in controller");
    return ResponseEntity.ok().build();
  }
}

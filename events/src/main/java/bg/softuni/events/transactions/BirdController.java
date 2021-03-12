package bg.softuni.events.transactions;

import javax.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BirdController {

  private final BirdRepository birdRepository;
  private final BirdEventPublisher publisher;

  public BirdController(BirdRepository birdRepository,
      BirdEventPublisher publisher) {
    this.birdRepository = birdRepository;
    this.publisher = publisher;
  }

  @Transactional
  @PostMapping("/bird")
  public ResponseEntity<BirdEntity> createBird(@RequestBody BirdEntity bird) {
    System.out.println("Bird created!");
    publisher.publishEvent(bird.getBreed());
    birdRepository.save(bird);
    return ResponseEntity.ok().build();
  }

}

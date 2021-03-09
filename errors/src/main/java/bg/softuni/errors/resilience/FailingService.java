package bg.softuni.errors.resilience;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FailingService {

  private static final Logger LOGGER = LoggerFactory.getLogger(FailingService.class);

  private AtomicInteger counter = new AtomicInteger();

  @CircuitBreaker(name="sampleConfig")// TODO: fix the circuit breaker.
  //@Retry(name="sampleConfig")
  public void fail() {
    LOGGER.info("I'm going to fail!");
    counter.incrementAndGet();
    throw new RuntimeException("I'm failing!");
  }

  public int getNumberOfCalls() {
    return counter.intValue();
  }

}

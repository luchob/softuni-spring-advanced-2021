package bg.softuni.errors.resilience;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FailingService {

  private static final Logger LOGGER = LoggerFactory.getLogger(FailingService.class);

  private AtomicInteger numberOfCalls = new AtomicInteger(0);

  @CircuitBreaker(name = "sampleConfig")
  @Retry(name = "sampleConfig")
  public String fail() {
    numberOfCalls.incrementAndGet();
    LOGGER.info("Calling failure...");
    throw new RuntimeException("I'm designed to fail (designed in Germany, made in China)!");
  }

  public Integer getNumberOfCalls() {
    return numberOfCalls.intValue();
  }
}

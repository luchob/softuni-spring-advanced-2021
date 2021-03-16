package bg.softuni.aop.annotation;

import bg.softuni.aop.annotation.SLOsConfig.SLOConfig;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class SLOAspect {

  private final SLOsConfig configs;

  public SLOAspect(SLOsConfig configs) {
    this.configs = configs;
  }

  @Around(value = "@annotation(TrackLatency)")
  public void trackLatency(ProceedingJoinPoint pjp,
      TrackLatency TrackLatency) throws Throwable {
    String latencyId = TrackLatency.latency();
    SLOConfig config = configs.getSlos().
        stream().
        filter(s -> s.getId().equals(latencyId)).
        findAny().orElseThrow(() -> new IllegalStateException("Configuration with id " + latencyId + " not found!"));

    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    pjp.proceed();
    stopWatch.stop();

    long actualLatency = stopWatch.getLastTaskTimeMillis();
    if (actualLatency > config.getThreshold()) {
      // IN reality - more complicated tracking.
      System.out.println("WARN: WE ARE TOO SLOW");
    } else {
      System.out.println("We are OK.");
    }
  }

}

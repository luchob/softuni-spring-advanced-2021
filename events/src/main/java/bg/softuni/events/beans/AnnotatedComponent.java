package bg.softuni.events.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
public class AnnotatedComponent {

  private static Logger LOGGER = LoggerFactory.getLogger(AnnotatedComponent.class);

  @PostConstruct
  public void postConstruct() {
    LOGGER.info("post construct");
  }

  @PreDestroy
  public void preDestroy() {
    LOGGER.info("Help, I'm dying!");
  }

}

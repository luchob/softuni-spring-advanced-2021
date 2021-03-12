package bg.softuni.events.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//@Component
public class IfcComponent implements InitializingBean, DisposableBean {

  private static Logger LOGGER = LoggerFactory.getLogger(IfcComponent.class);


  @Override
  public void destroy() throws Exception {
    LOGGER.info("Help, I'm dying!");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    LOGGER.info("All my porperties are set!");
  }
}

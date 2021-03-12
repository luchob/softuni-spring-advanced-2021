package bg.softuni.events.beans;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component
public class ContextAwareComponent implements ApplicationContextAware, BeanFactoryAware {

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

  }
}

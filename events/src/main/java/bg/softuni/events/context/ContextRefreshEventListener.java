package bg.softuni.events.context;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//@Component
public class ContextRefreshEventListener {

  @EventListener(ContextRefreshedEvent.class)
  public void onContextRefresh(ContextRefreshedEvent evt) {

  }

}

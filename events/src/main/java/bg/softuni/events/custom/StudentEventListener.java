package bg.softuni.events.custom;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentEventListener {

  @EventListener(StudentEvent.class)
  public void onStudentEvent(StudentEvent event) {
    System.out.println("Student event received!!!");
    System.out.println(event);
  }

}

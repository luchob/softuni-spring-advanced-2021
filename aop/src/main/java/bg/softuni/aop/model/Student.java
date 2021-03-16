package bg.softuni.aop.model;

import org.springframework.stereotype.Component;

@Component
public class Student {

  public void actionOne() {
    System.out.println("Action one");
  }

  public void actionTwo() {
    System.out.println("Action two");
  }

  public void sayHello() {
    System.out.println(getHello());
  }

  public String getHello() {
    return "Hello!";
  }

  public void echo(String whatToEcho) {
    System.out.println("I'll echo: " + whatToEcho);
  }

}

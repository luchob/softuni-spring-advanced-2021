package bg.softuni.proxies.cache;

import java.util.List;

public class StudentService implements StudentServiceIfc{

  @Cacheable("students")
  @Override
  public List<Student> getAllStudents() {

    System.out.println("Calculating students...");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return List.of(new Student().setName("Anna"),
        new Student().setName("Pesho"));
  }
}

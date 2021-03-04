package bg.softuni.restvalidation;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class  RestValidationServiceModel {

  @Size(min = 3)
  private String name;
  @Min(18)
  private int age;

  public String getName() {
    return name;
  }

  public RestValidationServiceModel setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public RestValidationServiceModel setAge(int age) {
    this.age = age;
    return this;
  }

  @Override
  public String toString() {
    return "RestValidationServiceModel{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}

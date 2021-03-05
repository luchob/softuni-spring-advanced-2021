package bg.softuni.restvalidation;

import javax.validation.constraints.Min;

public class PersonModel {

  @Min(18)
  private int age;
  private String name;

  public int getAge() {
    return age;
  }

  public PersonModel setAge(int age) {
    this.age = age;
    return this;
  }

  public String getName() {
    return name;
  }

  public PersonModel setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String toString() {
    return "PersonModel{" +
        "age=" + age +
        ", name='" + name + '\'' +
        '}';
  }
}

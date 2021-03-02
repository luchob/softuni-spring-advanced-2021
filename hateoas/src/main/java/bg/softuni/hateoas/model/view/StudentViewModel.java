package bg.softuni.hateoas.model.view;

import java.util.Set;

public class StudentViewModel {

  private Long id;
  private String name;
  private Integer age;
  //private Set<OrderViewModel> orders;

  public Long getId() {
    return id;
  }

  public StudentViewModel setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public StudentViewModel setName(String name) {
    this.name = name;
    return this;
  }

  public Integer getAge() {
    return age;
  }

  public StudentViewModel setAge(Integer age) {
    this.age = age;
    return this;
  }

//  public Set<OrderViewModel> getOrders() {
//    return orders;
//  }
//
//  public StudentViewModel setOrders(
//      Set<OrderViewModel> orders) {
//    this.orders = orders;
//    return this;
//  }
}

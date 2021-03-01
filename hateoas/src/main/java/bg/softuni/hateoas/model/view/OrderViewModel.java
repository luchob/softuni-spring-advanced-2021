package bg.softuni.hateoas.model.view;

import bg.softuni.hateoas.model.entity.Order;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "orders")
public class OrderViewModel {

  private long id;
  private long studentId;
  private long courseId;

  public long getId() {
    return id;
  }

  public OrderViewModel setId(long id) {
    this.id = id;
    return this;
  }

  public long getStudentId() {
    return studentId;
  }

  public OrderViewModel setStudentId(long studentId) {
    this.studentId = studentId;
    return this;
  }

  public long getCourseId() {
    return courseId;
  }

  public OrderViewModel setCourseId(long courseId) {
    this.courseId = courseId;
    return this;
  }

  public static OrderViewModel asDTO(Order order) {
    return new OrderViewModel().
        setId(order.getId()).
        setCourseId(order.getCourse().getId()).
        setStudentId(order.getStudent().getId());
  }

}

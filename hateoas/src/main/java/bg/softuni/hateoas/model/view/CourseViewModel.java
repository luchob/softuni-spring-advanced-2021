package bg.softuni.hateoas.model.view;

import java.math.BigDecimal;
import net.minidev.json.annotate.JsonIgnore;

public class CourseViewModel {
  private Long id;
  private String name;
  private BigDecimal price;
  @JsonIgnore
  private boolean enabled;

  public Long getId() {
    return id;
  }

  public CourseViewModel setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public CourseViewModel setName(String name) {
    this.name = name;
    return this;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public CourseViewModel setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public CourseViewModel setEnabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }
}

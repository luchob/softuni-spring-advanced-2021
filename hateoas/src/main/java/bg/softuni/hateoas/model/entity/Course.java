package bg.softuni.hateoas.model.entity;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    private Long id;
    private String name;
    private BigDecimal price;
    private boolean enabled;

    public Course() {
    }


    @Column(name = "name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public Course setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Course setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}

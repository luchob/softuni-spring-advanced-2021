package bg.softuni.security.model;

import bg.softuni.security.model.enums.UserRole;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRoleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", nullable = false, updatable = false)
  private long id;

  @Enumerated(EnumType.STRING)
  private UserRole role;

  public long getId() {
    return id;
  }

  public UserRoleEntity setId(long id) {
    this.id = id;
    return this;
  }

  public UserRole getRole() {
    return role;
  }

  public UserRoleEntity setRole(UserRole role) {
    this.role = role;
    return this;
  }
}

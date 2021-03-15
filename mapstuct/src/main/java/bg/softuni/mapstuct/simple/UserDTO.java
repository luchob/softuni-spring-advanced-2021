package bg.softuni.mapstuct.simple;

class UserDTO {

  private String name;

  public String getName() {
    return name;
  }

  public UserDTO setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String toString() {
    return "UserDTO{" +
        "name='" + name + '\'' +
        '}';
  }
}

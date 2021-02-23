package bg.softuni.restclient.model;

public class Author {

  private long id;
  private String name;

  public long getId() {
    return id;
  }

  public Author setId(long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Author setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String toString() {
    return "Author{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}

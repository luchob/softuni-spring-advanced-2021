package bg.sofunit.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private long id;

  @Column(nullable = false)
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "author",
              cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
  private List<Book> books = new ArrayList<>();

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

  public List<Book> getBooks() {
    return books;
  }

  public Author setBooks(List<Book> books) {
    this.books = books;
    return this;
  }

  @Override
  public String toString() {
    return "Author{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", books=" + books +
        '}';
  }
}

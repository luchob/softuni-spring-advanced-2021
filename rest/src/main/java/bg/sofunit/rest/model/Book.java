package bg.sofunit.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @Column(nullable = false)
  private String title;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="author_id", nullable=false)
  private Author author;

  public Long getId() {
    return id;
  }

  public Book setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Book setTitle(String title) {
    this.title = title;
    return this;
  }

  public Author getAuthor() {
    return author;
  }

  public Book setAuthor(Author author) {
    this.author = author;
    return this;
  }
}

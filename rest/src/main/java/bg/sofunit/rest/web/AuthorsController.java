package bg.sofunit.rest.web;

import bg.sofunit.rest.model.Author;
import bg.sofunit.rest.model.Book;
import bg.sofunit.rest.repository.AuthorRepository;
import bg.sofunit.rest.repository.AuthorsSearchSpecification;
import bg.sofunit.rest.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class AuthorsController implements AuthorsNamespace {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public AuthorsController(AuthorRepository authorRepository,
      BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @GetMapping
  public List<Author> getAll(
      @RequestParam(required = false) String authorName,
      @RequestParam(required = false) String bookTitle) {
    return authorRepository.findAll(new AuthorsSearchSpecification(authorName, bookTitle));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Author> getById(@PathVariable Long id) {
    Optional<Author> authorOpt = authorRepository.
        findById(id);
    return authorOpt.map(ResponseEntity::ok).
        orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/{authorid}/books")
  public List<Book> findBooks(@PathVariable Long authorid) {
    // TODO: 404
    Author author = authorRepository.
        findById(authorid).get();

    return bookRepository.findBooksByAuthor(author);
  }


  @PostMapping
  public ResponseEntity<Author> create(
      @RequestBody Author author,
      UriComponentsBuilder ucBuilder) {
    Author newAuthor = authorRepository.save(author);
    return ResponseEntity.created(
        ucBuilder.path("/authors/{authorId}").buildAndExpand(newAuthor.getId()).toUri()
    ).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Author> deleteById(@PathVariable Long id) {
    authorRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}

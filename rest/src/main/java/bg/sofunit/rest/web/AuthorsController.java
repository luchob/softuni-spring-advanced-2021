package bg.sofunit.rest.web;

import bg.sofunit.rest.model.Author;
import bg.sofunit.rest.model.AuthorSearchSpecification;
import bg.sofunit.rest.repository.AuthorRepository;
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

  public AuthorsController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @GetMapping("/search")
  public List<Author> searchAuthors(
      @RequestParam(required = false, name = "name") String name,
      @RequestParam(required = false, name = "book_title") String bookTitle) {
    AuthorSearchSpecification searchSpec = new AuthorSearchSpecification(name, bookTitle);
    return authorRepository.findAll(searchSpec);
  }

  @GetMapping
  public List<Author> getAuthors() {
    return authorRepository.findAll();
  }

  @GetMapping("/{authorId}")
  public ResponseEntity<Author> getAuthor(@PathVariable Long authorId) {
    Optional<Author> theAuthor = authorRepository.findById(authorId);
    return theAuthor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Author> create(
      UriComponentsBuilder ucBuilder,
      @RequestBody Author author) {
    Author newAuthor = authorRepository.save(author);
    return ResponseEntity.
        created(ucBuilder.path("/authors/{authroId}").buildAndExpand(newAuthor.getId()).toUri()).
        build();
  }

  @DeleteMapping("/{authorId}")
  public ResponseEntity<Author> delete(@PathVariable Long authorId) {
    authorRepository.deleteById(authorId);
    return ResponseEntity.noContent().build();
  }
}

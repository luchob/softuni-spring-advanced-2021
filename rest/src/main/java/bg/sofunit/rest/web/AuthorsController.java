package bg.sofunit.rest.web;

import bg.sofunit.rest.model.Author;
import bg.sofunit.rest.repository.AuthorRepository;
import bg.sofunit.rest.repository.AuthorsSearchSpecification;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorsController implements AuthorsNamespace {

  private final AuthorRepository authorRepository;

  public AuthorsController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
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

  @DeleteMapping("/{id}")
  public ResponseEntity<Author> deleteById(@PathVariable Long id) {
    authorRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}

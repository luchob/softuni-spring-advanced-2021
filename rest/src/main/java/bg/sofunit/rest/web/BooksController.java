package bg.sofunit.rest.web;

import bg.sofunit.rest.model.Author;
import bg.sofunit.rest.model.Book;
import bg.sofunit.rest.repository.AuthorRepository;
import bg.sofunit.rest.repository.BookRepository;
import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class BooksController implements AuthorsNamespace {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;

  public BooksController(BookRepository bookRepository,
      AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  @GetMapping("/{authorId}/books")
  public ResponseEntity<List<Book>> getAuthor(@PathVariable Long authorId) {
    Optional<Author> theAuthor = authorRepository.findById(authorId);
    return theAuthor.
        map(Author::getBooks).
        map(ResponseEntity::ok).
        orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/{authorId}/books/{bookId}")
  public ResponseEntity<Book> getBook(
      @PathVariable Long authorId,
      @PathVariable Long bookId) {
    Optional<Book> theBook = bookRepository.findById(bookId);
    return theBook.
        filter(book -> book.getAuthor().getId() == authorId).
        map(ResponseEntity::ok).
        orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{authorId}/books/{bookId}")
  public ResponseEntity<Book> deleteBook(
      @PathVariable Long authorId,
      @PathVariable Long bookId) {
    Optional<Book> theBook = bookRepository.findById(bookId);
    if (theBook.isPresent()) {
      if (theBook.get().getAuthor().getId() != authorId) {
        return ResponseEntity.badRequest().build();
      } else {
        bookRepository.delete(theBook.get());
        return ResponseEntity.noContent().build();
      }
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/{authorId}/books")
  public ResponseEntity<Book> createBook(
      UriComponentsBuilder ucBuilder,
      @PathVariable Long authorId,
      Book theBook) {
    if (theBook.getId() != null) {
      return ResponseEntity.badRequest().build();
    } else {
      Optional<Author> theAuthor = authorRepository.findById(authorId);
      if (theAuthor.isEmpty()) {
        return ResponseEntity.badRequest().build();
      } else {
        theBook.setAuthor(theAuthor.get());
        theBook = bookRepository.save(theBook);
        return ResponseEntity.
            created(ucBuilder.path("/authors/{authroId}/books/{bookId}").
                buildAndExpand(authorId, theBook.getId()).toUri()).body(theBook);
      }
    }
  }

  @PutMapping("/{authorId}/books")
  public ResponseEntity<Book> updateBook(
      @PathVariable Long authorId,
      Book theBook) {
    if (theBook.getId() == null) {
      return ResponseEntity.badRequest().build();
    } else {
      Optional<Author> theAuthor = authorRepository.findById(authorId);
      if (theAuthor.isEmpty()) {
        return ResponseEntity.badRequest().build();
      } else {
        theBook.setAuthor(theAuthor.get());
        theBook = bookRepository.save(theBook);
        return ResponseEntity.ok(theBook);
      }
    }
  }
}

package bg.sofunit.rest.repository;

import bg.sofunit.rest.model.Author;
import bg.sofunit.rest.model.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findBooksByAuthor(Author author);

}

package bg.sofunit.rest.repository;

import bg.sofunit.rest.model.Author;
import bg.sofunit.rest.model.Book;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;

public class AuthorsSearchSpecification implements Specification<Author> {

  private final String authorName;
  private final String bookTitle;

  public AuthorsSearchSpecification(String authorName, String bookTitle) {

    this.authorName = authorName;
    this.bookTitle = bookTitle;
  }

  @Override
  public Predicate toPredicate(
      Root<Author> root,
      CriteriaQuery<?> query,
      CriteriaBuilder cb) {

    Predicate p = cb.conjunction();

    if (authorName != null) {
      p.getExpressions().add(
          cb.and(cb.equal(root.get("name"), authorName))
      );
    }

    if (bookTitle != null) {
      Subquery<Book> bookSubquery = query.subquery(Book.class);
      Root<Book> subqueryRoot = bookSubquery.from(Book.class);
      bookSubquery.select(subqueryRoot);

      bookSubquery.where(
          cb.and(
              cb.equal(root, subqueryRoot.get("author")),
              cb.equal(subqueryRoot.get("title"), bookTitle)
          )
      );

      p.getExpressions().add(cb.exists(bookSubquery));
    }

    return p;
  }
}

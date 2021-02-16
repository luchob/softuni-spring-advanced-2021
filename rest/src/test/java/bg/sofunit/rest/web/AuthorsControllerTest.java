package bg.sofunit.rest.web;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import bg.sofunit.rest.model.Author;
import bg.sofunit.rest.repository.AuthorRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private AuthorRepository authorRepository;

  private long author1Id, author2Id;

  private String author1Name = "author1", author2Name = "author2";

  @BeforeEach
  public void setUp() {

    authorRepository.deleteAll();

    Author author1 = new Author();
    Author author2 = new Author();

    author1.setName(author1Name);
    author2.setName(author2Name);

    List<Author> authors = authorRepository.saveAll(List.of(author1, author2));
    author1Id = authors.get(0).getId();
    author2Id = authors.get(1).getId();

  }

  @AfterEach
  public void tearDown() {
    authorRepository.deleteAll();
  }


  @Test
  public void testGetAuthorsOK() throws Exception {
      this.mockMvc.perform(get("/authors")).
          andExpect(status().isOk());
  }

  @Test
  public void testAuthorsNotFound() throws Exception {
    this.mockMvc.
        perform(get("/authors/{id}", 6666)).
        andExpect(status().isNotFound());
  }

  @Test
  public void testAuthorFound() throws Exception {
    this.mockMvc.
        perform(get("/authors/{id}", author1Id)).
        andExpect(jsonPath("$.name", is(author1Name))).
        andExpect(status().isOk());
  }

  @Test
  public void testGetAuthorsCorrect() throws Exception {
    this.mockMvc.perform(get("/authors")).
        andExpect(status().isOk()).
        andExpect(jsonPath("$", hasSize(2))).
        andExpect(jsonPath("$.[0].name", is(author1Name))).
        andExpect(jsonPath("$.[1].name", is(author2Name)));
  }

}

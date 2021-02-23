package bg.softuni.restclient;

import bg.softuni.restclient.model.Author;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClientInit implements CommandLineRunner {

  private final RestTemplate restTemplate;

  public RestClientInit(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public void run(String... args) {
    ResponseEntity<Author[]> authorsResponse = restTemplate.
        getForEntity("http://localhost:8080/authors",
        Author[].class);

    if (authorsResponse.hasBody()) {
      Author[] authors = authorsResponse.getBody();
      for (Author a : authors) {
        System.out.println(a);
      }
    }
  }
}

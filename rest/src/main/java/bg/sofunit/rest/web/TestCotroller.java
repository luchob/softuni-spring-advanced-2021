package bg.sofunit.rest.web;

import bg.sofunit.rest.model.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCotroller {

  @GetMapping("/echo")
  public String echo(@RequestParam String text) {
    return text;
  }

}

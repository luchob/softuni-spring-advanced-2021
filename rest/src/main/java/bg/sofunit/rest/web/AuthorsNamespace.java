package bg.sofunit.rest.web;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(AuthorsNamespace.AUTHORS_URI)
public interface AuthorsNamespace {
  String AUTHORS_URI = "/authors";
}

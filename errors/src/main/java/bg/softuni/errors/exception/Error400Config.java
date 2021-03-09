package bg.softuni.errors.exception;

import java.util.Map;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequest;

@Configuration
public class Error400Config {

  // uncomment to add softuni attib.
  //@Bean
  DefaultErrorAttributes errorAttributes() {
    return new DefaultErrorAttributes() {
      @Override
      public Map<String, Object> getErrorAttributes(WebRequest webRequest,
          ErrorAttributeOptions options) {
        Map<String, Object> allAtrribs = super.getErrorAttributes(webRequest, options);

        allAtrribs.put("softuni", "true");

        return allAtrribs;
      }
    };
  }

}

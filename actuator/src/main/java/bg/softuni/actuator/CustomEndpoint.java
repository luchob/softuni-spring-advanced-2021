package bg.softuni.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(enableByDefault = true, id="custom")
public class CustomEndpoint {
  @ReadOperation
  public Information getMyEndpoint(){
    return new Information(
        "It is 19:28 now",
        "This is a hardcoded value, but might be dynamic :-)"
    );
  }

  static class Information {

    private final String info;
    private final String description;

    public Information(String info, String description) {
      this.info = info;
      this.description = description;
    }

    public String getInfo() {
      return info;
    }

    public String getDescription() {
      return description;
    }
  }
}


package bg.softuni.aop.annotation;

import java.util.LinkedList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "slos-config")
public class SLOsConfig {

  private List<SLOConfig> slos = new LinkedList<>();

  public List<SLOConfig> getSlos() {
    return slos;
  }

  public SLOsConfig setSlos(List<SLOConfig> slos) {
    this.slos = slos;
    return this;
  }

  public static class SLOConfig {
    private int threshold;
    private String id;

    public int getThreshold() {
      return threshold;
    }

    public SLOConfig setThreshold(int threshold) {
      this.threshold = threshold;
      return this;
    }

    public String getId() {
      return id;
    }

    public SLOConfig setId(String id) {
      this.id = id;
      return this;
    }
  }

}

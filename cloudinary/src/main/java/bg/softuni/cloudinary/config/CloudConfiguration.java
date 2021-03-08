package bg.softuni.cloudinary.config;

import com.cloudinary.Cloudinary;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudConfiguration {
    @Value("${cloudinary.cloud-name}")
    private String cloudApiName;
    @Value("${cloudinary.api-key}")
    private String cloudApiKey;
    @Value("${cloudinary.api-secret}")
    private String cloudApiSecret;

    @Bean
    public Cloudinary cloudinary() {

        Map<String, Object> config = new HashMap<>();

        config.put("cloud_name", cloudApiName);
        config.put("api_key", cloudApiKey);
        config.put("api_secret", cloudApiSecret);

        return new Cloudinary(config);
    }
}

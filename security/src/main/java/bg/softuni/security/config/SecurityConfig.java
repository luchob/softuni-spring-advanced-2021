package bg.softuni.security.config;

import bg.softuni.security.security.DemoUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //TODO:
    throw new UnsupportedOperationException();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    //TODO:
    throw new UnsupportedOperationException();
  }
}

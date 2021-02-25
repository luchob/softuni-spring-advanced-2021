package bg.softuni.security.config;

import bg.softuni.security.security.DemoUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;
  private final DemoUserDetailsService userDetailsService;

  public SecurityConfig(
      PasswordEncoder passwordEncoder,
      DemoUserDetailsService userDetailsService) {
    this.passwordEncoder = passwordEncoder;
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.
        userDetailsService(userDetailsService).
        passwordEncoder(passwordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.
        authorizeRequests().
        antMatchers("/h2_console/**", "/home").permitAll().
        antMatchers("/admin").hasRole("ADMIN").
        antMatchers("/user").hasRole("USER").
        and().formLogin();

    //h2 database
    http.csrf().disable();
    http.headers().frameOptions().disable();
  }
}

package bg.softuni.security.security;

import bg.softuni.security.model.UserEntity;
import bg.softuni.security.model.UserRoleEntity;
import bg.softuni.security.repository.UserRepository;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DemoUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public DemoUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserEntity> demoUser = userRepository.findByName(username);

    return demoUser.
        map(this::mapToUserDetails).
        orElseThrow(() -> new UsernameNotFoundException("User " + username +" not found!"));
  }

  private UserDetails mapToUserDetails(UserEntity userEntity) {
    return new User(userEntity.getName(),
        userEntity.getPassword(),
        userEntity.
            getRoles().
            stream().
            map(this::mapToGrantedAuthority).
            collect(Collectors.toList()));
  }

  private GrantedAuthority mapToGrantedAuthority(UserRoleEntity userRoleEntity) {
    return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole());
  }
}

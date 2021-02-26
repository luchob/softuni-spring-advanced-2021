package bg.softuni.security.security;

import bg.softuni.security.model.UserEntity;
import bg.softuni.security.repository.UserRepository;
import bg.softuni.security.repository.UserRoleRepository;
import java.util.List;
import java.util.stream.Collectors;
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
    UserEntity userEntity = userRepository.findByName(username).orElseThrow(
        () -> new UsernameNotFoundException("User with name " + username + " was not found."));

    return mapToUserDetails(userEntity);
  }

  private UserDetails mapToUserDetails(UserEntity userEntity) {

    List<SimpleGrantedAuthority> authorities = userEntity.
        getRoles().
        stream().
        map(ur -> new SimpleGrantedAuthority("ROLE_" + ur.getRole().name())).
        collect(Collectors.toList());

    return new User(
        userEntity.getName(),
        userEntity.getPassword(),
        authorities
    );
  }
}

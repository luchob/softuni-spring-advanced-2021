package bg.softuni.security;

import bg.softuni.security.model.UserEntity;
import bg.softuni.security.model.UserRoleEntity;
import bg.softuni.security.model.enums.UserRole;
import bg.softuni.security.repository.UserRepository;
import bg.softuni.security.repository.UserRoleRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityApplicationInit  implements CommandLineRunner {

  private final UserRepository userRepository;
  private final UserRoleRepository userRoleRepository;
  private final PasswordEncoder passwordEncoder;

  public SecurityApplicationInit(
      UserRepository userRepository,
      UserRoleRepository userRoleRepository,
      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.userRoleRepository = userRoleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void run(String... args)  {

    UserRoleEntity userRole = userRoleRepository.save(new UserRoleEntity().setRole(UserRole.USER));
    UserRoleEntity adminRole = userRoleRepository.save(new UserRoleEntity().setRole(UserRole.ADMIN));

    //simple user
    UserEntity userEntity = new UserEntity();
    userEntity.setName("user");
    userEntity.setPassword(passwordEncoder.encode("topsecret"));
    userEntity.setRoles(List.of(userRole));

    UserEntity admin = new UserEntity();
    admin.setName("admin");
    admin.setPassword(passwordEncoder.encode("topsecret"));
    admin.setRoles(List.of(adminRole, userRole));

    userRepository.save(userEntity);
    userRepository.save(admin);
  }
}

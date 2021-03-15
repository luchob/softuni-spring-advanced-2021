package bg.softuni.mapstuct.simple;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimpleMapperExample implements CommandLineRunner {

  private final UserMapper userMapper;

  public SimpleMapperExample(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public void run(String... args) throws Exception {
    User user = new User().setName("Pesho");
    UserDTO userDTO = new UserDTO().setName("Gosho");

    User mappedUser = userMapper.dtoToUser(userDTO);
    UserDTO mappedUserDTO = userMapper.userToDTO(user);

    System.out.println(mappedUser);
    System.out.println(mappedUserDTO);
  }

}

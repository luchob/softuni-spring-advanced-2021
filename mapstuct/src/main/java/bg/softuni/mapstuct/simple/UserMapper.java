package bg.softuni.mapstuct.simple;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDTO userToDTO(User user);

  User dtoToUser(UserDTO userDTO);
}

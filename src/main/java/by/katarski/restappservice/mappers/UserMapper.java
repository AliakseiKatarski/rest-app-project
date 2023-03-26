package by.katarski.restappservice.mappers;

import by.katarski.restappservice.dto.UserCreateDto;
import by.katarski.restappservice.dto.UserDto;
import by.katarski.restappservice.model.entity.User;

public interface UserMapper {
    UserDto toDto(User user);

    User toUser(UserCreateDto userDto);
}

package by.katarski.restappservice.mappers.impl;

import by.katarski.restappservice.dto.UserCreateDto;
import by.katarski.restappservice.dto.UserDto;
import by.katarski.restappservice.mappers.UserMapper;
import by.katarski.restappservice.model.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFullName(user.getLastName() + " "
                + user.getFirstName() + " "
                + user.getSurname());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        return userDto;
    }

    @Override
    public User toUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setSurname(userCreateDto.getSurname());
        user.setEmail(userCreateDto.getEmail());
        user.setRoles(userCreateDto.getRoles());
        return user;
    }
}

package by.katarski.restappservice.service;

import by.katarski.restappservice.dto.UserCreateDto;
import by.katarski.restappservice.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    void save(UserCreateDto userCreateDto);

}

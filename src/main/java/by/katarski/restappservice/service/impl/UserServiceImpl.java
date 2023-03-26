package by.katarski.restappservice.service.impl;

import by.katarski.restappservice.dto.UserCreateDto;
import by.katarski.restappservice.dto.UserDto;
import by.katarski.restappservice.mappers.UserMapper;
import by.katarski.restappservice.model.entity.User;
import by.katarski.restappservice.model.repository.UserRepository;
import by.katarski.restappservice.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository repository,
                           UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(User::getEmail))
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserCreateDto userCreateDto) {
        User user = userMapper.toUser(userCreateDto);
        repository.save(user);
    }
}

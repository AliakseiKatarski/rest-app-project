package by.katarski.restappservice.service.impl;

import by.katarski.restappservice.dto.UserCreateDto;
import by.katarski.restappservice.dto.UserDto;
import by.katarski.restappservice.mappers.UserMapper;
import by.katarski.restappservice.model.entity.Role;
import by.katarski.restappservice.model.entity.User;
import by.katarski.restappservice.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository repository;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void whenUsersExistUserServiceGetAllUsersReturnValidList() {
        List<User> userList = List.of(
                new User(1L, "Test", "Test",
                        "Test", "Test", Set.of(Role.Sale_User)),
                new User(2L, "Test1", "Test1",
                        "Test1", "Test1", Set.of(Role.Administrator)),
                new User(3L, "Test2", "Test2",
                        "Test2", "Test2", Set.of(Role.Customer_User))
        );
        when(this.repository.findAll()).thenReturn(userList);


        List<UserDto> userDto = userService.getAllUsers();


        assertNotNull(userDto);
        assertEquals(3, userDto.size());
        assertFalse(userDto.isEmpty());
        verify(this.repository).findAll();
        verify(this.userMapper, times(1)).toDto(userList.get(0));

        assertAll(
                () -> {
                    verify(this.userMapper).toDto(userList.get(0));
                },
                () -> {
                    verify(this.userMapper).toDto(userList.get(1));
                },
                () -> {
                    verify(this.userMapper).toDto(userList.get(2));
                }

        );
    }

    @Test
    void whenUserNotExistUserServiceGetAllReturnEmptyList() {
        List<User> userList = new ArrayList<>();
        when(this.repository.findAll()).thenReturn(userList);

        List<UserDto> userDto = userService.getAllUsers();

        assertTrue(userDto.isEmpty());
        assertNotNull(userDto);
        assertEquals(0, userDto.size());
        verify(this.repository).findAll();
        verifyNoInteractions(this.userMapper);

    }

    @Test
    void saveShouldCallsRepository() {
        UserCreateDto userCreateDto = mock(UserCreateDto.class);
        User user = mock(User.class);
        when(this.userMapper.toUser(userCreateDto)).thenReturn(user);

        this.userService.save(userCreateDto);

        verify(this.repository).save(user);
        verify(this.userMapper).toUser(userCreateDto);

    }

}

package by.katarski.restappservice.controller;

import by.katarski.restappservice.dto.UserCreateDto;
import by.katarski.restappservice.dto.UserDto;
import by.katarski.restappservice.model.entity.Role;
import by.katarski.restappservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController controller;

    @Test
    void usersReturnValidResponseEntity() {
        List<UserDto> userDto = List.of(
                new UserDto("Test", "Test", Set.of(Role.Administrator)),
                new UserDto("Test1", "Test1", Set.of(Role.Customer_User)),
                new UserDto("Test2", "Test2", Set.of(Role.Secure_API_User))
        );
        when(userService.getAllUsers()).thenReturn(userDto);


        var responseEntity = this.controller.users();
        System.out.println(responseEntity);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(userDto, responseEntity.getBody());
        verify(this.userService).getAllUsers();


    }

    @Test
    void addPayloadIsValidReturnValidResponseEntity() {
        UserCreateDto userCreateDto = new UserCreateDto("Test", "Test",
                "Test", "Test", Set.of(Role.Sale_User));

        var responseEntity = this.controller.add(userCreateDto);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(userCreateDto, responseEntity.getBody());
        verify(this.userService).save(userCreateDto);


    }


}


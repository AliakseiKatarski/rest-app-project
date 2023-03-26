package by.katarski.restappservice.mappers.impl;

import by.katarski.restappservice.dto.UserDto;
import by.katarski.restappservice.model.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserMapperImplTest {
    @Mock
    private UserMapperImpl userMapper;

    @Test
    void whenUserNotNullMapperReturnCorrectUserDto() {
        User user = mock(User.class);
        UserDto userDto = mock(UserDto.class);
        when(this.userMapper.toDto(user)).thenReturn(userDto);

        UserDto testUserDto = userMapper.toDto(user);

        assertNotNull(testUserDto);
        assertEquals(userDto, testUserDto);
        verify(this.userMapper).toDto(user);

    }

    @Test
    void whenUserIsNullMapperThrowsIllegalArgumentException() {
        IllegalArgumentException argumentException = new IllegalArgumentException("User is null!");
        when(this.userMapper.toDto(null)).thenThrow(argumentException);


        var exception = assertThrows(IllegalArgumentException.class, () -> {
            this.userMapper.toDto(null);

        });

        assertEquals("User is null!", exception.getMessage());


    }

}

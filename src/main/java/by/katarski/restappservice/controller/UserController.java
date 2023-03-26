package by.katarski.restappservice.controller;

import by.katarski.restappservice.dto.UserCreateDto;
import by.katarski.restappservice.dto.UserDto;
import by.katarski.restappservice.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<UserDto>> users() {
        log.info("Get all users request");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserCreateDto> add(
            @RequestBody @Valid UserCreateDto userCreateDto) {

        this.userService.save(userCreateDto);
        log.info("User {} was successfully saved", userCreateDto);
        return ResponseEntity.created(URI.create(userCreateDto.getEmail()))
                .contentType(MediaType.APPLICATION_JSON)
                .body(userCreateDto);

    }
}

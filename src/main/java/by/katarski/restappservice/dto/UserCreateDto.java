package by.katarski.restappservice.dto;

import by.katarski.restappservice.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    @Size(min = 2, max = 20,
            message = "Your name must be between 2 and 20 characters")
    @Pattern(regexp = "^[A-Za-z]+$")
    @NotBlank
    private String firstName;
    @Size(min = 1, max = 40,
            message = "Your last name must be between 1 and 40 characters")
    @Pattern(regexp = "^[A-Za-z]+$")
    @NotBlank
    private String lastName;
    @Size(min = 5, max = 40,
            message = "Your surname must be between 5 and 40 characters")
    @Pattern(regexp = "^[A-Za-z]+$")
    @NotBlank
    private String surname;
    @Email(message = "Please enter a valid email")
    @NotBlank
    private String email;
    private Set<Role> roles;
}

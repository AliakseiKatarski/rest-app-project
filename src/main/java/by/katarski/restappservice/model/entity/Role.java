package by.katarski.restappservice.model.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    Administrator("Administrator"),
    Sale_User("Sale_User"),
    Customer_User("Customer_User"),
    Secure_API_User("Secure_API_User");

    private final String roleName;

    @JsonValue
    public String getRoleName() {
        return roleName;
    }
}

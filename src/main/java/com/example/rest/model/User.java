package com.example.rest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class User {
    @NotBlank
    @Size(min = 3, max = 20)
    private String user;
    @NotBlank
    @Size(min = 5, max = 20)
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user1 = (User) object;
        return Objects.equals(user, user1.user) && Objects.equals(password, user1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }
}

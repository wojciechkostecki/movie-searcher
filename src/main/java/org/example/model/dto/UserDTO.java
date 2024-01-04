package org.example.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO {

    private Long id;

    @NotBlank(message = "Login is mandatory")
    @Size(min = 5, message = "Login requires a minimum of 5 characters")
    private String login;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 5, message = "Password requires a minimum of 5 characters")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

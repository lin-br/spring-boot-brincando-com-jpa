package br.com.tilmais.springbootbrincandocomjpa.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestDTO {

    @NotNull
    @Size(min = 5, max = 45)
    private String name;

    @NotNull
    @Size(max = 60)
    @Email
    private String email;

    @NotNull
    @Size(min = 8, max = 20)
    private String password;

    @NotNull
    private Long profile;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getProfile() {
        return profile;
    }
}

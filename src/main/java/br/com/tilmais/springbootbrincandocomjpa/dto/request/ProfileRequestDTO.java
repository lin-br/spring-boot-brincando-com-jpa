package br.com.tilmais.springbootbrincandocomjpa.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProfileRequestDTO {

    @NotNull
    @Size(min = 5, max = 60)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

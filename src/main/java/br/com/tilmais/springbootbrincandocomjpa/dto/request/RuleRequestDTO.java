package br.com.tilmais.springbootbrincandocomjpa.dto.request;

import br.com.tilmais.springbootbrincandocomjpa.model.entity.MethodRule;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RuleRequestDTO {

    @NotNull
    @Size(min = 5, max = 100)
    private String url;

    @NotNull
    private MethodRule method;

    @NotNull
    @Size(min = 5, max = 140)
    private String description;

    public String getUrl() {
        return url;
    }

    public MethodRule getMethod() {
        return method;
    }

    public String getDescription() {
        return description;
    }
}

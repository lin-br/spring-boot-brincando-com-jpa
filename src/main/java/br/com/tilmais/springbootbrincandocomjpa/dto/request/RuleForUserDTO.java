package br.com.tilmais.springbootbrincandocomjpa.dto.request;

import javax.validation.constraints.NotNull;

public class RuleForUserDTO {

    @NotNull
    private Long idRule;

    public Long getIdRule() {
        return idRule;
    }
}

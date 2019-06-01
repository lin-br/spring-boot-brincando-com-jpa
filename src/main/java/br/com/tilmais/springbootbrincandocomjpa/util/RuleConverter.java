package br.com.tilmais.springbootbrincandocomjpa.util;

import br.com.tilmais.springbootbrincandocomjpa.dto.response.RuleResponseDTO;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.Rule;

public class RuleConverter {

    public static RuleResponseDTO getDTO(Rule rule) {
        return new RuleResponseDTO.Builder(rule.getResource(), rule.getMethod(), rule.getDescription())
                .setCreated_at(rule.getCreated_at())
                .setModified_at(rule.getModified_at())
                .setDeleted_at(rule.getDeleted_at())
                .setId(rule.getId())
                .build();
    }
}

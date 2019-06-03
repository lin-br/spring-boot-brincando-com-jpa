package br.com.tilmais.springbootbrincandocomjpa.service;

import br.com.tilmais.springbootbrincandocomjpa.dto.request.RuleRequestDTO;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.Rule;
import br.com.tilmais.springbootbrincandocomjpa.model.repository.RuleRepository;
import br.com.tilmais.springbootbrincandocomjpa.util.GeneratorURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class RuleService {

    private RuleRepository ruleRepository;

    @Autowired
    public RuleService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public URI registerRule(RuleRequestDTO request) {
        Rule rule = new Rule();
        rule.setResource(request.getResource());
        rule.setMethod(request.getMethod());
        rule.setDescription(request.getDescription());
        return GeneratorURI.getUriAddId(this.ruleRepository.save(rule).getId());
    }
}

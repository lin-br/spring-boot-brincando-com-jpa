package br.com.tilmais.springbootbrincandocomjpa.controller;

import br.com.tilmais.springbootbrincandocomjpa.dto.request.RuleRequestDTO;
import br.com.tilmais.springbootbrincandocomjpa.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("rules")
public class RuleController {

    private RuleService ruleService;

    @Autowired
    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@Valid @RequestBody RuleRequestDTO ruleDTO) {
        return ResponseEntity.created(this.ruleService.registerRule(ruleDTO)).build();
    }
}

package br.com.tilmais.springbootbrincandocomjpa.controller;

import br.com.tilmais.springbootbrincandocomjpa.dto.request.RuleForUserDTO;
import br.com.tilmais.springbootbrincandocomjpa.service.UsersRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users/{idUser}/rules",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class UsersRulesControllers {

    private UsersRulesService usersRulesService;

    @Autowired
    public UsersRulesControllers(UsersRulesService usersRulesService) {
        this.usersRulesService = usersRulesService;
    }

    @PostMapping
    public ResponseEntity registerRule(@PathVariable Long idUser, @Valid @RequestBody RuleForUserDTO request) {
        return ResponseEntity.created(this.usersRulesService.registerRuleForUser(request, idUser)).build();
    }
}

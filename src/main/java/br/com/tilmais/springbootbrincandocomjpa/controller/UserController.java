package br.com.tilmais.springbootbrincandocomjpa.controller;

import br.com.tilmais.springbootbrincandocomjpa.dto.request.RuleForUserDTO;
import br.com.tilmais.springbootbrincandocomjpa.dto.request.UserRequestDTO;
import br.com.tilmais.springbootbrincandocomjpa.dto.response.UserResponseDTO;
import br.com.tilmais.springbootbrincandocomjpa.service.UserHasRulesService;
import br.com.tilmais.springbootbrincandocomjpa.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;
    private UserHasRulesService userHasRulesService;

    public UserController(UserService userService, UserHasRulesService userHasRulesService) {
        this.userService = userService;
        this.userHasRulesService = userHasRulesService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@Valid @RequestBody UserRequestDTO user) {
        return ResponseEntity.created(this.userService.registerUser(user)).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserResponseDTO> getAll() {
        return this.userService.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDTO get(@PathVariable Long id) {
        return this.userService.getUser(id);
    }

    @PostMapping(value = "/{id}/rules/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerRuleForUser(@PathVariable Long id, @Valid @RequestBody RuleForUserDTO request) {
        return ResponseEntity.created(this.userHasRulesService.registerRuleForUser(request, id)).build();
    }
}

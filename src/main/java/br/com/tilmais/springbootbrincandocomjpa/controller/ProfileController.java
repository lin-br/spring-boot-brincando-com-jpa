package br.com.tilmais.springbootbrincandocomjpa.controller;

import br.com.tilmais.springbootbrincandocomjpa.dto.request.ProfileRequestDTO;
import br.com.tilmais.springbootbrincandocomjpa.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("profiles")
public class ProfileController {

    private ProfileService service;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.service = profileService;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity register(@Valid @RequestBody ProfileRequestDTO request) {
        return ResponseEntity.created(this.service.registerProfile(request)).build();
    }
}

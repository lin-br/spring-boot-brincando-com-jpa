package br.com.tilmais.springbootbrincandocomjpa.service;

import br.com.tilmais.springbootbrincandocomjpa.dto.request.RuleForUserDTO;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.PksUsersHasRules;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.Rule;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.User;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.UsersHasRules;
import br.com.tilmais.springbootbrincandocomjpa.model.repository.RuleRepository;
import br.com.tilmais.springbootbrincandocomjpa.model.repository.UserHasRulesRepository;
import br.com.tilmais.springbootbrincandocomjpa.model.repository.UserRepository;
import br.com.tilmais.springbootbrincandocomjpa.util.GeneratorURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Service
public class UsersRulesService {

    private RuleRepository ruleRepository;
    private UserRepository userRepository;
    private UserHasRulesRepository userHasRulesRepository;

    @Autowired
    public UsersRulesService(RuleRepository ruleRepository,
                             UserRepository userRepository,
                             UserHasRulesRepository userHasRulesRepository) {
        this.ruleRepository = ruleRepository;
        this.userRepository = userRepository;
        this.userHasRulesRepository = userHasRulesRepository;
    }

    public URI registerRuleForUser(RuleForUserDTO request, Long idUser) throws URISyntaxException {
        final URI uriWithoutResources = GeneratorURI.getUriWithoutResources();

        Optional<User> optionalUser = this.userRepository.findById(idUser);
        Optional<Rule> optionalRule = this.ruleRepository.findById(request.getIdRule());

        long idSession =
                Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());

        Optional<User> optionalUserSession = this.userRepository.findById(idSession);

        if (optionalUserSession.isPresent()) {
            if (optionalUser.isPresent() && optionalRule.isPresent()) {
                UsersHasRules usersHasRules = new UsersHasRules();

                PksUsersHasRules pksUsersHasRules = new PksUsersHasRules();
                pksUsersHasRules.setRule(optionalRule.get());
                pksUsersHasRules.setUser(optionalUser.get());
                pksUsersHasRules.setRegisteredUser(optionalUserSession.get());

                usersHasRules.setPks(pksUsersHasRules);

                this.userHasRulesRepository.save(usersHasRules);

                return uriWithoutResources;
            }
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "User or rule are not valid!");
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No user logged in");
    }
}

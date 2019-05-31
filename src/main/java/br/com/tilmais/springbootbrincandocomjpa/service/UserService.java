package br.com.tilmais.springbootbrincandocomjpa.service;

import br.com.tilmais.springbootbrincandocomjpa.dto.request.UserRequestDTO;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.Profile;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.SituationUser;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.User;
import br.com.tilmais.springbootbrincandocomjpa.model.repository.ProfileRepository;
import br.com.tilmais.springbootbrincandocomjpa.model.repository.UserRepository;
import br.com.tilmais.springbootbrincandocomjpa.util.GeneratorURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Optional;

@Service
public class UserService {

    private ProfileRepository profileRepository;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    public URI registerUser(UserRequestDTO request) {
        Optional<Profile> byId = profileRepository.findById(request.getProfile());
        if (byId.isPresent()) {
            User user = new User(request.getName(),
                    request.getEmail(),
                    request.getPassword(),
                    SituationUser.ACTIVED,
                    byId.get()
            );
            Long id = this.userRepository.save(user).getId();
            return GeneratorURI.getUriAddId(id);
        }
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "No profile with id: " + request.getProfile());
    }
}
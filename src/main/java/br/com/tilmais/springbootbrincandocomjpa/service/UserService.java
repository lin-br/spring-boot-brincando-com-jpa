package br.com.tilmais.springbootbrincandocomjpa.service;

import br.com.tilmais.springbootbrincandocomjpa.dto.request.UserRequestDTO;
import br.com.tilmais.springbootbrincandocomjpa.dto.response.UserResponseDTO;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.Profile;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.User;
import br.com.tilmais.springbootbrincandocomjpa.model.repository.ProfileRepository;
import br.com.tilmais.springbootbrincandocomjpa.model.repository.UserRepository;
import br.com.tilmais.springbootbrincandocomjpa.util.GeneratorURI;
import br.com.tilmais.springbootbrincandocomjpa.util.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
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
            User user = new User();
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setProfile(byId.get());
            Long id = this.userRepository.save(user).getId();
            return GeneratorURI.getUriAddId(id);
        }
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "No profile with id: " + request.getProfile());
    }

    public List<UserResponseDTO> getAll() {
        List<UserResponseDTO> lista = new ArrayList<>();
        this.userRepository.findAll().forEach(user -> lista.add(UserConverter.getDtoFull(user)));
        return lista;
    }

    public UserResponseDTO getUser(Long id) {
        Optional<User> optional = this.userRepository.findById(id);
        if (optional.isPresent()) {
            return UserConverter.getDtoSimple(optional.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
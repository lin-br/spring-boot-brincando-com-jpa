package br.com.tilmais.springbootbrincandocomjpa.service;

import br.com.tilmais.springbootbrincandocomjpa.dto.request.ProfileRequestDTO;
import br.com.tilmais.springbootbrincandocomjpa.dto.response.ProfileResponseDTO;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.Profile;
import br.com.tilmais.springbootbrincandocomjpa.model.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {

    private ProfileRepository repository;

    @Autowired
    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public URI registerProfile(ProfileRequestDTO request) {
        Profile profile = new Profile(request.getName());
        Long id = this.repository.save(profile).getId();
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    public List<ProfileResponseDTO> getAll() {
        List<ProfileResponseDTO> listaResponse = new ArrayList<>();
        this.repository
                .findAll()
                .forEach(profile -> listaResponse.add(new ProfileResponseDTO(
                        profile.getId(),
                        profile.getName(),
                        profile.getCreated_at(),
                        profile.getModified_at(),
                        profile.getDeleted_at(),
                        profile.getRules()
                )));
        return listaResponse;
    }
}

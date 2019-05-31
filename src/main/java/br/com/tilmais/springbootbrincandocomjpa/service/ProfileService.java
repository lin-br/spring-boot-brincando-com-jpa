package br.com.tilmais.springbootbrincandocomjpa.service;

import br.com.tilmais.springbootbrincandocomjpa.dto.request.ProfileRequestDTO;
import br.com.tilmais.springbootbrincandocomjpa.dto.response.ProfileResponseDTO;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.Profile;
import br.com.tilmais.springbootbrincandocomjpa.model.repository.ProfileRepository;
import br.com.tilmais.springbootbrincandocomjpa.util.GeneratorURI;
import br.com.tilmais.springbootbrincandocomjpa.util.ProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return GeneratorURI.getUriAddId(id);
    }

    public List<ProfileResponseDTO> getAll() {
        List<ProfileResponseDTO> listaResponse = new ArrayList<>();
        this.repository.findAll().forEach(profile -> listaResponse.add(ProfileConverter.getResponseDTO(profile)));
        return listaResponse;
    }
}

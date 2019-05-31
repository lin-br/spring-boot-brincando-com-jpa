package br.com.tilmais.springbootbrincandocomjpa.util;

import br.com.tilmais.springbootbrincandocomjpa.dto.response.ProfileResponseDTO;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.Profile;

public class ProfileConverter {

    public static ProfileResponseDTO getResponseDTO(Profile profile) {
        return new ProfileResponseDTO(
                profile.getId(),
                profile.getName(),
                profile.getCreated_at(),
                profile.getModified_at(),
                profile.getDeleted_at(),
                profile.getRules()
        );
    }
}

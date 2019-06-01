package br.com.tilmais.springbootbrincandocomjpa.util;

import br.com.tilmais.springbootbrincandocomjpa.dto.response.ProfileResponseDTO;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.Profile;

public class ProfileConverter {

    public static ProfileResponseDTO getResponseDTO(Profile profile) {
        ProfileResponseDTO.Builder builder = new ProfileResponseDTO.Builder(profile.getName())
                .setId(profile.getId())
                .setCreated_at(profile.getCreated_at())
                .setModified_at(profile.getModified_at())
                .setDeleted_at(profile.getDeleted_at());
        profile.getProfilesHasRules().forEach(profilesHasRules -> builder.addRule(profilesHasRules.getRule()));
        return builder.build();
    }
}

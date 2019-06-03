package br.com.tilmais.springbootbrincandocomjpa.util;

import br.com.tilmais.springbootbrincandocomjpa.dto.response.UserResponseDTO;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.User;

public class UserConverter {

    public static UserResponseDTO getDtoFull(User user) {
        UserResponseDTO.Builder builder = new UserResponseDTO.Builder(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getSituation(),
                user.getCreated_at(),
                user.getModified_at(),
                user.getDeleted_at())
                .setProfile(ProfileConverter.getResponseDTO(user.getProfile()));
        user.getUsersHasRules().forEach(usersHasRules -> builder.addRule(usersHasRules.getRule()));
        return builder.build();
    }

    public static UserResponseDTO getDtoSimple(User user) {
        return new UserResponseDTO.Builder(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getSituation(),
                user.getCreated_at(),
                user.getModified_at(),
                user.getDeleted_at())
                .build();
    }
}

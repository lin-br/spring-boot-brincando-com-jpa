package br.com.tilmais.springbootbrincandocomjpa.util;

import br.com.tilmais.springbootbrincandocomjpa.dto.response.UserResponseDTO;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.User;

public class UserConverter {

    public static UserResponseDTO getResponseDTO(User user) {
        UserResponseDTO.Builder builder = new UserResponseDTO.Builder(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getSituation(),
                ProfileConverter.getResponseDTO(user.getProfile()))
                .setCreated_at(user.getCreated_at())
                .setModified_at(user.getModified_at())
                .setDeleted_at(user.getDeleted_at());
        user.getRules().forEach(usersHasRules -> builder.addRule(usersHasRules.getRule()));
        return builder.build();
    }
}

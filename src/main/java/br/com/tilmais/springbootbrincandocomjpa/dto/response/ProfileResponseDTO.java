package br.com.tilmais.springbootbrincandocomjpa.dto.response;

import br.com.tilmais.springbootbrincandocomjpa.model.entity.ProfilesHasRules;

import java.util.Calendar;
import java.util.Set;

public class ProfileResponseDTO {

    private Long id;
    private String nome;
    private Calendar created_at;
    private Calendar modified_at;
    private Calendar deleted_at;
    private Set<ProfilesHasRules> rules;

    public ProfileResponseDTO(Long id, String nome, Calendar created_at, Calendar modified_at, Calendar deleted_at, Set<ProfilesHasRules> rules) {
        this.id = id;
        this.nome = nome;
        this.created_at = created_at;
        this.modified_at = modified_at;
        this.deleted_at = deleted_at;
        this.rules = rules;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Calendar getCreated_at() {
        return created_at;
    }

    public Calendar getModified_at() {
        return modified_at;
    }

    public Calendar getDeleted_at() {
        return deleted_at;
    }

    public Set<ProfilesHasRules> getRules() {
        return rules;
    }
}

package br.com.tilmais.springbootbrincandocomjpa.dto.response;

import br.com.tilmais.springbootbrincandocomjpa.model.entity.Rule;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.SituationUser;
import br.com.tilmais.springbootbrincandocomjpa.util.RuleConverter;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private SituationUser situation;
    private ProfileResponseDTO profile;
    private Calendar created_at;
    private Calendar modified_at;
    private Calendar deleted_at;
    private Set<RuleResponseDTO> rules;

    private UserResponseDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.situation = builder.situation;
        this.profile = builder.profile;
        this.created_at = builder.created_at;
        this.modified_at = builder.modified_at;
        this.deleted_at = builder.deleted_at;
        this.rules = builder.rules;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public SituationUser getSituation() {
        return situation;
    }

    public ProfileResponseDTO getProfile() {
        return profile;
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

    public Set<RuleResponseDTO> getRules() {
        return rules;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String email;
        private String password;
        private SituationUser situation;
        private ProfileResponseDTO profile;
        private Calendar created_at;
        private Calendar modified_at;
        private Calendar deleted_at;
        private Set<RuleResponseDTO> rules = new HashSet<>();

        public Builder(Long id, String name, String email, String password, SituationUser situation, Calendar created_at, Calendar modified_at, Calendar deleted_at) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.situation = situation;
            this.created_at = created_at;
            this.modified_at = modified_at;
            this.deleted_at = deleted_at;
        }

        public Builder setProfile(ProfileResponseDTO profile) {
            this.profile = profile;
            return this;
        }

        public Builder addRule(Rule rule) {
            this.rules.add(RuleConverter.getDTO(rule));
            return this;
        }

        public UserResponseDTO build() {
            return new UserResponseDTO(this);
        }
    }
}

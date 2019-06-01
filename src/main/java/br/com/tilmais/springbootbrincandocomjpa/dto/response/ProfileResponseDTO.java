package br.com.tilmais.springbootbrincandocomjpa.dto.response;

import br.com.tilmais.springbootbrincandocomjpa.model.entity.Rule;
import br.com.tilmais.springbootbrincandocomjpa.util.RuleConverter;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class ProfileResponseDTO {

    private Long id;
    private String nome;
    private Calendar created_at;
    private Calendar modified_at;
    private Calendar deleted_at;
    private Set<RuleResponseDTO> rules;

    private ProfileResponseDTO(Builder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.created_at = builder.created_at;
        this.modified_at = builder.modified_at;
        this.deleted_at = builder.deleted_at;
        this.rules = builder.rules;
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

    public Set<RuleResponseDTO> getRules() {
        return rules;
    }

    public static class Builder {
        private Long id;
        private String nome;
        private Calendar created_at;
        private Calendar modified_at;
        private Calendar deleted_at;
        private Set<RuleResponseDTO> rules = new HashSet<>();

        public Builder(String nome) {
            this.nome = nome;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCreated_at(Calendar created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder setModified_at(Calendar modified_at) {
            this.modified_at = modified_at;
            return this;
        }

        public Builder setDeleted_at(Calendar deleted_at) {
            this.deleted_at = deleted_at;
            return this;
        }

        public Builder addRule(Rule rule) {
            this.rules.add(RuleConverter.getDTO(rule));
            return this;
        }

        public ProfileResponseDTO build() {
            return new ProfileResponseDTO(this);
        }
    }
}

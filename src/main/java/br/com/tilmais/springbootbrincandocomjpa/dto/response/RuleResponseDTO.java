package br.com.tilmais.springbootbrincandocomjpa.dto.response;

import br.com.tilmais.springbootbrincandocomjpa.model.entity.MethodRule;

import java.util.Calendar;

public class RuleResponseDTO {

    private Long id;
    private String resource;
    private MethodRule method;
    private String description;
    private Calendar created_at;
    private Calendar modified_at;
    private Calendar deleted_at;

    private RuleResponseDTO(Builder builder) {
        this.id = builder.id;
        this.resource = builder.resource;
        this.method = builder.method;
        this.description = builder.description;
        this.created_at = builder.created_at;
        this.modified_at = builder.modified_at;
        this.deleted_at = builder.deleted_at;
    }

    public Long getId() {
        return id;
    }

    public String getResource() {
        return resource;
    }

    public MethodRule getMethod() {
        return method;
    }

    public String getDescription() {
        return description;
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

    public static class Builder {

        private Long id;
        private String resource;
        private MethodRule method;
        private String description;
        private Calendar created_at;
        private Calendar modified_at;
        private Calendar deleted_at;

        public Builder(String resource, MethodRule method, String description) {
            this.resource = resource;
            this.method = method;
            this.description = description;
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

        public RuleResponseDTO build() {
            return new RuleResponseDTO(this);
        }
    }
}

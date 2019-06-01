package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "rules")
@DynamicInsert
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String resource;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private MethodRule method;

    @Column(nullable = false, length = 140)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Calendar created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar modified_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar deleted_at;

    public Rule() {
    }

    public Rule(String resource, MethodRule method, String description) {
        this.resource = resource;
        this.method = method;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public MethodRule getMethod() {
        return method;
    }

    public void setMethod(MethodRule method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getCreated_at() {
        return created_at;
    }

    public Calendar getModified_at() {
        return modified_at;
    }

    public void setModified_at(Calendar modified_at) {
        this.modified_at = modified_at;
    }

    public Calendar getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Calendar deleted_at) {
        this.deleted_at = deleted_at;
    }
}

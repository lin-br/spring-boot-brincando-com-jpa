package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

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

    @OneToMany(mappedBy = "pks.rule")
    private Set<ProfilesHasRules> profilesHasRules;

    @OneToMany(mappedBy = "pks.rule")
    private Set<UsersHasRules> usersHasRules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setCreated_at(Calendar created_at) {
        this.created_at = created_at;
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

    public Set<ProfilesHasRules> getProfilesHasRules() {
        return profilesHasRules;
    }

    public void setProfilesHasRules(Set<ProfilesHasRules> profilesHasRules) {
        this.profilesHasRules = profilesHasRules;
    }

    public Set<UsersHasRules> getUsersHasRules() {
        return usersHasRules;
    }

    public void setUsersHasRules(Set<UsersHasRules> usersHasRules) {
        this.usersHasRules = usersHasRules;
    }
}

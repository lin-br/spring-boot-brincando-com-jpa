package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profiles")
@DynamicInsert
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Calendar created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar modified_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar deleted_at;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pks.profile")
    private Set<ProfilesHasRules> profilesHasRules = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

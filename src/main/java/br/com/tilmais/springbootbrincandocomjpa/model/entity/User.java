package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "users")
@DynamicInsert
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(length = 60, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 8)
    @ColumnDefault("'ACTIVED'")
    private SituationUser situation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "profile_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_id_profile"))
    private Profile profile;

    @Temporal(TemporalType.TIMESTAMP)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Calendar created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar modified_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar deleted_at;

    @OneToMany(mappedBy = "user")
    private Set<UsersHasRules> usersHasRules;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SituationUser getSituation() {
        return situation;
    }

    public void setSituation(SituationUser situation) {
        this.situation = situation;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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

    public Set<UsersHasRules> getUsersHasRules() {
        return usersHasRules;
    }

    public void setUsersHasRules(Set<UsersHasRules> usersHasRules) {
        this.usersHasRules = usersHasRules;
    }
}

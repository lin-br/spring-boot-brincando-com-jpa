package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
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
    private Set<UsersHasRules> rules = new HashSet<>();

    public User() {
    }

    public User(String name, String email, String password, SituationUser situation, Profile profile) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.situation = situation;
        this.profile = profile;
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

    public void setSituation(SituationUser situation) {
        this.situation = situation;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<UsersHasRules> getRules() {
        return Collections.unmodifiableSet(rules);
    }

    public void addRule(Rule rule, User registeredUser) {
        UsersHasRules usersHasRules = new UsersHasRules(rule, this, registeredUser);
        this.rules.add(usersHasRules);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setModified_at(Calendar modified_at) {
        this.modified_at = modified_at;
    }

    public void setDeleted_at(Calendar deleted_at) {
        this.deleted_at = deleted_at;
    }
}

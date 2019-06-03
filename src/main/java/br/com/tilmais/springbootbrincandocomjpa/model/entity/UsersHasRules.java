package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "users_has_rules")
@DynamicInsert
public class UsersHasRules {

    @EmbeddedId
    private PksUsersHasRules pks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_rule"))
    @MapsId("idRule")
    private Rule rule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_user"))
    @MapsId("idUser")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_registered_user"))
    @MapsId("idRegisteredUser")
    private User registeredUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "link_status", nullable = false, length = 8)
    @ColumnDefault("'ACTIVED'")
    private LinkStatus linkStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Calendar registration_date;

    public PksUsersHasRules getPks() {
        return pks;
    }

    public void setPks(PksUsersHasRules pks) {
        this.pks = pks;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(User registeredUser) {
        this.registeredUser = registeredUser;
    }

    public LinkStatus getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(LinkStatus linkStatus) {
        this.linkStatus = linkStatus;
    }

    public Calendar getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Calendar registration_date) {
        this.registration_date = registration_date;
    }
}

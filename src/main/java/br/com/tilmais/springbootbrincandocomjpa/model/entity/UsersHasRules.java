package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "users_has_rules")
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
    private LinkStatus linkStatus = LinkStatus.ACTIVED;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Calendar registration_date;

    public UsersHasRules() {
    }

    public UsersHasRules(Rule rule, User user, User registeredUser) {
        this.rule = rule;
        this.user = user;
        this.registeredUser = registeredUser;
        this.pks = new PksUsersHasRules(rule.getId(), user.getId(), registeredUser.getId());
    }

    public PksUsersHasRules getPks() {
        return pks;
    }

    public Rule getRule() {
        return rule;
    }

    public User getUser() {
        return user;
    }

    public User getRegisteredUser() {
        return registeredUser;
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
}

package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "profiles_has_rules")
public class ProfilesHasRules {

    @EmbeddedId
    private PksAssociationRulesProfiles pks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_rule"))
    @MapsId("idRule")
    private Rule rule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_profile"))
    @MapsId("idProfile")
    private Profile profile;

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

    public ProfilesHasRules(Rule rule, Profile profile, User registeredUser) {
        this.rule = rule;
        this.profile = profile;
        this.registeredUser = registeredUser;
        this.pks = new PksAssociationRulesProfiles(rule.getId(), profile.getId(), registeredUser.getId());
    }

    public PksAssociationRulesProfiles getPks() {
        return pks;
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

    public Rule getRule() {
        return rule;
    }

    public Profile getProfile() {
        return profile;
    }

    public User getRegisteredUser() {
        return registeredUser;
    }
}

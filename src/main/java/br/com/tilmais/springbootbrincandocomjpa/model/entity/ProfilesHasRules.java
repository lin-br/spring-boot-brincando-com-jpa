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
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Calendar registration_date;

    public PksAssociationRulesProfiles getPks() {
        return pks;
    }

    public void setPks(PksAssociationRulesProfiles pks) {
        this.pks = pks;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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

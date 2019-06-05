package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "profiles_has_rules")
@DynamicInsert
@AssociationOverrides({
        @AssociationOverride(name = "pks.rule", joinColumns = @JoinColumn(name = "rule_id"), foreignKey = @ForeignKey(name = "fk_id_rule")),
        @AssociationOverride(name = "pks.profile", joinColumns = @JoinColumn(name = "profile_id"), foreignKey = @ForeignKey(name = "fk_id_profile")),
        @AssociationOverride(name = "pks.registeredUser", joinColumns = @JoinColumn(name = "registered_user_id"), foreignKey = @ForeignKey(name = "fk_id_registered_user"))
})
public class ProfilesHasRules {

    @EmbeddedId
    private PksAssociationRulesProfiles pks = new PksAssociationRulesProfiles();

    @Enumerated(EnumType.STRING)
    @Column(name = "link_status", nullable = false, length = 8)
    @ColumnDefault("'ACTIVED'")
    private LinkStatus linkStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Calendar registration_date;

    public PksAssociationRulesProfiles getPks() {
        return pks;
    }

    public void setPks(PksAssociationRulesProfiles pks) {
        this.pks = pks;
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

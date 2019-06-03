package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PksAssociationRulesProfiles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "rule_id")
    private Long idRule;

    @Column(name = "profile_id")
    private Long idProfile;

    @Column(name = "registered_user_id")
    private Long idRegisteredUser;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdRule() {
        return idRule;
    }

    public void setIdRule(Long idRule) {
        this.idRule = idRule;
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public Long getIdRegisteredUser() {
        return idRegisteredUser;
    }

    public void setIdRegisteredUser(Long idRegisteredUser) {
        this.idRegisteredUser = idRegisteredUser;
    }
}

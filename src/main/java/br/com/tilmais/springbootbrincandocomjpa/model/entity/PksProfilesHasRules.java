package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PksProfilesHasRules implements Serializable {

    private static final long serialVersionUID = -2290603860298289041L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_rule"))
    private Rule rule;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_profile"))
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_registered_user"))
    private User registeredUser;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PksProfilesHasRules)) return false;
        PksProfilesHasRules that = (PksProfilesHasRules) o;
        return getRule().equals(that.getRule()) &&
                getProfile().equals(that.getProfile()) &&
                getRegisteredUser().equals(that.getRegisteredUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRule(), getProfile(), getRegisteredUser());
    }

}

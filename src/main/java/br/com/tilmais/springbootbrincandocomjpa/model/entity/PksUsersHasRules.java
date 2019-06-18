package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PksUsersHasRules implements Serializable {

    private static final long serialVersionUID = -571178021380689798L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_rule"))
    private Rule rule;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_id_user"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User registeredUser;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PksUsersHasRules)) return false;
        PksUsersHasRules that = (PksUsersHasRules) o;
        return getRule().equals(that.getRule()) &&
                getUser().equals(that.getUser()) &&
                getRegisteredUser().equals(that.getRegisteredUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRule(), getUser(), getRegisteredUser());
    }
}

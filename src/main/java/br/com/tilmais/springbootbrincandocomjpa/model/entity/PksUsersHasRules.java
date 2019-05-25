package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PksUsersHasRules implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "rule_id")
    private Long idRule;

    @Column(name = "user_id")
    private Long idUser;

    @Column(name = "registered_user_id")
    private Long idRegisteredUser;

    public PksUsersHasRules() {
    }

    public PksUsersHasRules(Long idRule, Long idUser, Long idRegisteredUser) {
        this.idRule = idRule;
        this.idUser = idUser;
        this.idRegisteredUser = idRegisteredUser;
    }

    public Long getIdRule() {
        return idRule;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Long getIdRegisteredUser() {
        return idRegisteredUser;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof PksUsersHasRules)) return false;
        PksUsersHasRules that = (PksUsersHasRules) object;
        return getIdRule().equals(that.getIdRule()) &&
                getIdUser().equals(that.getIdUser()) &&
                getIdRegisteredUser().equals(that.getIdRegisteredUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdRule(), getIdUser(), getIdRegisteredUser());
    }
}

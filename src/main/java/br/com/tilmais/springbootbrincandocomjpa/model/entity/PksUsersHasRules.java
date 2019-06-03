package br.com.tilmais.springbootbrincandocomjpa.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PksUsersHasRules implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "rule_id")
    private Long idRule;

    @Column(name = "user_id")
    private Long idUser;

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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdRegisteredUser() {
        return idRegisteredUser;
    }

    public void setIdRegisteredUser(Long idRegisteredUser) {
        this.idRegisteredUser = idRegisteredUser;
    }
}

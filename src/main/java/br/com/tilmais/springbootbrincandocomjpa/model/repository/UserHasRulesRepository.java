package br.com.tilmais.springbootbrincandocomjpa.model.repository;

import br.com.tilmais.springbootbrincandocomjpa.model.entity.PksUsersHasRules;
import br.com.tilmais.springbootbrincandocomjpa.model.entity.UsersHasRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHasRulesRepository extends JpaRepository<UsersHasRules, PksUsersHasRules> {
}

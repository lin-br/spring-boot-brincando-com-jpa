package br.com.tilmais.springbootbrincandocomjpa.model.repository;

import br.com.tilmais.springbootbrincandocomjpa.model.entity.Rule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends CrudRepository<Rule, Long> {

}

package br.com.tilmais.springbootbrincandocomjpa.model.repository;

import br.com.tilmais.springbootbrincandocomjpa.model.entity.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}

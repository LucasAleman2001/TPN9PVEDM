package ar.edu.unju.edm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.modelo.PersonaTesteada;

@Repository
public interface IPersonaTesteadaRepository extends CrudRepository<PersonaTesteada, Long>{
	

	public void deleteById(Long idPersonaTesteada);

	public Optional<PersonaTesteada> findById(Long idPersonaTesteada);
}

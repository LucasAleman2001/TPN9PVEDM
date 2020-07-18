package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.modelo.PersonaTesteada;

@Repository
public interface IPersonaTesteadaRepository extends CrudRepository<PersonaTesteada, Integer>{
	
	public List<PersonaTesteada> listarPersonaTesteada();
}

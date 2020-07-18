package ar.edu.unju.edm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.modelo.Barrio;

@Repository
public interface IBarrioRepository extends CrudRepository<Barrio, Long>{
	
}

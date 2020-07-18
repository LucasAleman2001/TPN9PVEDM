package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.modelo.Barrio;

@Repository
public interface IBarrioRepository extends CrudRepository<Barrio, Long>{
	
	@Query("from Localidad e order by e.id")
	public List<Barrio> listarBarrios();
}

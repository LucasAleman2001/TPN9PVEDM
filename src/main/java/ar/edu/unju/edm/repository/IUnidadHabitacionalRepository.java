package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.modelo.UnidadHabitacional;

@Repository
public interface IUnidadHabitacionalRepository extends CrudRepository<UnidadHabitacional, Long>{
	
	@Query
	public List<UnidadHabitacional> listarUnidadesHabitacionales();
}

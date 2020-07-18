package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.modelo.RegistroTesteo;

@Repository
public interface IRegistroTesteoRepository extends CrudRepository<RegistroTesteo, Long>{
	
}

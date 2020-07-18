package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.modelo.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{
	
	@Query("from Usuario e order by e.id")
	public List<Usuario> listarUsuarios();
}
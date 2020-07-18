package ar.edu.unju.edm.service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.UnidadHabitacional;

@Service
public interface IUnidadHabitacionalService {
	
	public void guardarUnidadHabitacional(UnidadHabitacional unidadHabitacional);
	public UnidadHabitacional modificarUnidadHabitacional(UnidadHabitacional unidadHabitacional) throws Exception;
	public void eliminarUnidadHabitacional(Long idUnidadHabitacional);
	public UnidadHabitacional buscarUnidadHabitacional(Long idUnidadHabitacional) throws Exception;
	
}

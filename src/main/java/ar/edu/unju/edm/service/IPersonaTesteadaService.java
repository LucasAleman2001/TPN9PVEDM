package ar.edu.unju.edm.service;

import java.util.List;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.PersonaTesteada;

@Service
public interface IPersonaTesteadaService {
	
	public void guardarPersonaTesteada(PersonaTesteada personaTesteada);
	public void eliminarPersonaTesteada(Long idPersonaTesteada);
	public PersonaTesteada modificarPersonaTesteada(PersonaTesteada personaTesteada) throws Exception;
	public PersonaTesteada buscarPersonaTesteada(Long idPersonaTesteada) throws Exception;
	
}

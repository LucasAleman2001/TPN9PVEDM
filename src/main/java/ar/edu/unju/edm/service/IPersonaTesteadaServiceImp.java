package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.PersonaTesteada;
import ar.edu.unju.edm.repository.IPersonaTesteadaRepository;

@Service
public class IPersonaTesteadaServiceImp implements IPersonaTesteadaService {
	
	@Autowired
	IPersonaTesteadaRepository iPersonaTesteadaRepository;
	
	@Override
	public void guardarPersonaTesteada(PersonaTesteada personaTesteada) {
		iPersonaTesteadaRepository.save(personaTesteada);
	}

	@Override
	public List<PersonaTesteada> listarPersonasTesteadas() {
		return iPersonaTesteadaRepository.listarPersonaTesteada();
	}

	@Override
	public void eliminarPersonaTesteada(int idPersonaTesteada) {
		iPersonaTesteadaRepository.deleteById(idPersonaTesteada);
	}

	@Override
	public PersonaTesteada modificarPersonaTesteada(PersonaTesteada personaTesteada) throws Exception {
		PersonaTesteada personaTesteadaGuardado = buscarPersonaTesteada(personaTesteada.getIdPersonaTesteada());
		mapearPersonaTesteada(personaTesteada, personaTesteadaGuardado);
		return iPersonaTesteadaRepository.save(personaTesteadaGuardado);
	}
	public void mapearPersonaTesteada(PersonaTesteada desde, PersonaTesteada hacia) {
		hacia.setDocumento(desde.getDocumento());
		hacia.setApellido(desde.getApellido());
		hacia.setNombres(desde.getNombres());
		hacia.setResultadoTesteado(desde.getResultadoTesteado());
	}

	@Override
	public PersonaTesteada buscarPersonaTesteada(int idPersonaTesteada) throws Exception {
		return iPersonaTesteadaRepository.findById(idPersonaTesteada).orElseThrow(()-> new Exception("El usuario no existe"));
	}

}

package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.RegistroTesteo;

@Service
public interface IRegistroTesteoService {
	
	public void guardarRegistroTesteo(RegistroTesteo registroTesteo);
	public List<RegistroTesteo> listarRegistrosTesteos();
	public RegistroTesteo modificarRegistroTesteo(RegistroTesteo RegistroTesteo) throws Exception;
	public void eliminarRegistroTesteo(Long idRegistroTesteo);
	public RegistroTesteo buscarRegistroTesteo(Long idRegistroTesteo) throws Exception;
	
}

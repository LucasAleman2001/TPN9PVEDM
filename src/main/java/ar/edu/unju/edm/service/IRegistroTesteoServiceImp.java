package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.RegistroTesteo;
import ar.edu.unju.edm.repository.IRegistroTesteoRepository;

@Service
public class IRegistroTesteoServiceImp implements IRegistroTesteoService {
	
	@Autowired
	IRegistroTesteoRepository iRegistroTesteoRepository;
	
	@Override
	public void guardarRegistroTesteo(RegistroTesteo registroTesteo) {
		iRegistroTesteoRepository.save(registroTesteo);
	}

	@Override
	public List<RegistroTesteo> listarRegistrosTesteos() {
		return iRegistroTesteoRepository.listarRegistroTesteo();
	}

	@Override
	public RegistroTesteo modificarRegistroTesteo(RegistroTesteo registroTesteo) throws Exception {
		RegistroTesteo registroTesteoGuardado = buscarRegistroTesteo(registroTesteo.getIdRegistroTesteo());
		mapearRegistroTesteo(registroTesteo, registroTesteoGuardado);
		return iRegistroTesteoRepository.save(registroTesteoGuardado);
	}
	public void mapearRegistroTesteo(RegistroTesteo desde, RegistroTesteo hacia) {
		hacia.setFechahora(desde.getFechahora());
		hacia.setUnidad_habitacional(desde.getUnidad_habitacional());
		hacia.setPersona_testeada(desde.getPersona_testeada());
		
	}

	@Override
	public void eliminarRegistroTesteo(Long idRegistroTesteo) {
		iRegistroTesteoRepository.deleteById(idRegistroTesteo);
	}

	@Override
	public RegistroTesteo buscarRegistroTesteo(Long idRegistroTesteo) throws Exception {
		return iRegistroTesteoRepository.findById(idRegistroTesteo).orElseThrow(()-> new Exception("El RegistroTesteo no existe"));
	}

}

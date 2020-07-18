package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.UnidadHabitacional;
import ar.edu.unju.edm.repository.IUnidadHabitacionalRepository;

@Service
public class IUnidadHabitacionalServiceImp implements IUnidadHabitacionalService {
	
	@Autowired
	IUnidadHabitacionalRepository iUnidadHabitacionalRepository;
	
	@Override
	public void guardarUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		iUnidadHabitacionalRepository.save(unidadHabitacional);
	}

	@Override
	public List<UnidadHabitacional> listarUnidadesHabitacionales() {
		return iUnidadHabitacionalRepository.listarUnidadesHabitacionales();
	}

	@Override
	public UnidadHabitacional modificarUnidadHabitacional(UnidadHabitacional unidadHabitacional) throws Exception {
		UnidadHabitacional unidadHabitacionalGuardado = buscarUnidadHabitacional(unidadHabitacional.getIdUnidadHabitacional());
		mapearUnidadHabitacional(unidadHabitacional, unidadHabitacionalGuardado);
		return iUnidadHabitacionalRepository.save(unidadHabitacionalGuardado);
	}
	public void mapearUnidadHabitacional(UnidadHabitacional desde, UnidadHabitacional hacia) {
		hacia.setDireccion(desde.getDireccion());
		hacia.setBarrio(desde.getBarrio());
	}

	@Override
	public void eliminarUnidadHabitacional(Long idUnidadHabitacional) {
		iUnidadHabitacionalRepository.deleteById(idUnidadHabitacional);
	}

	@Override
	public UnidadHabitacional buscarUnidadHabitacional(Long idUnidadHabitacional) throws Exception {
		return iUnidadHabitacionalRepository.findById(idUnidadHabitacional).orElseThrow(()-> new Exception("El usuario no existe"));
	}

}

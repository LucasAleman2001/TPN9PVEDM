package ar.edu.unju.edm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Barrio;
import ar.edu.unju.edm.repository.IBarrioRepository;

@Service
public class IBarrioServiceImp implements IBarrioService {
	
	@Autowired
	IBarrioRepository iBarrioRepository;
	
	@Override
	public void guardarBarrio(Barrio barrio) {
		iBarrioRepository.save(barrio);
	}

	@Override
	public Barrio modificarBarrio(Barrio barrio) throws Exception {
		Barrio barrioGuardado = buscarBarrio(barrio.getIdBarrio());
		mapearBarrio(barrio, barrioGuardado);
		return iBarrioRepository.save(barrioGuardado);
	}
	public void mapearBarrio(Barrio desde, Barrio hacia) {
		hacia.setNombre(desde.getNombre());
	}

	@Override
	public void eliminarBarrio(Long idBarrio) {
		iBarrioRepository.deleteById(idBarrio);

	}

	@Override
	public Barrio buscarBarrio(Long idBarrio) throws Exception {
		return iBarrioRepository.findById(idBarrio).orElseThrow(()-> new Exception("El barrio no existe"));
	}

}

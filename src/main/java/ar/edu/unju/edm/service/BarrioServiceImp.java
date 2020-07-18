package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.modelo.Barrio;
import ar.edu.unju.edm.repository.IBarrioRepository;

public class BarrioServiceImp implements IBarrioService {
	
	@Autowired
	IBarrioRepository iBarrioRepository;
	
	@Autowired
	Barrio barrio;
	
	@Override
	public void guardarBarrio(Barrio barrio) {
		iBarrioRepository.save(barrio);
	}

	@Override
	public List<Barrio> listarBarrios() {
		return iBarrioRepository.listarBarrios();
	}

	@Override
	public Barrio modificarBarrio(Barrio barrio) throws Exception {
		Barrio barrioGuardar = encontrarBarrio(barrio.getIdBarrio());
		zonearBarrio(barrio, barrioGuardar);
		return iBarrioRepository.save(barrioGuardar);
	}
	public void zonearBarrio(Barrio desde, Barrio hacia) {
		hacia.setNombre(desde.getNombre());
	}

	@Override
	public void eliminarBarrio(Long idBarrio) {
		iBarrioRepository.deleteById(idBarrio);

	}

	@Override
	public Barrio buscarBarrio(Long idBarrio) throws Exception {
		iBarrioRepository.findById(idBarrio);
		return null;
	}

	@Override
	public Barrio encontrarBarrio(Long idBarrio) throws Exception {
		return iBarrioRepository.findById(idBarrio).orElseThrow(()-> new Exception("El barrio no existe"));
	}

}

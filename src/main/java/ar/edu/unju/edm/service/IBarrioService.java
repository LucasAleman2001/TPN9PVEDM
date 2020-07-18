package ar.edu.unju.edm.service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Barrio;

@Service
public interface IBarrioService {
	
	public void guardarBarrio(Barrio barrio);
	public Barrio modificarBarrio(Barrio barrio) throws Exception;
	public void eliminarBarrio(Long idBarrio);
	public Barrio buscarBarrio(Long idBarrio) throws Exception;
	
}

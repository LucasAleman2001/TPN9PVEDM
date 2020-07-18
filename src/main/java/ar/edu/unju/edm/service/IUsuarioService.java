package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Usuario;

@Service
public interface IUsuarioService {
	
	public void guardarUsuario(Usuario usuario);
	public List<Usuario> listarUsuarios();
	public void eliminarUsuario(long idUsuario);
	public Usuario modificarUsuario(Usuario usuario) throws Exception;
	public Usuario buscarUsuario(long idUsuario) throws Exception;
	
}

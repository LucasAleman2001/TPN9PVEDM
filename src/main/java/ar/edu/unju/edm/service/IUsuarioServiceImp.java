package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Usuario;
import ar.edu.unju.edm.repository.IUsuarioRepository;

@Service
public class IUsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	IUsuarioRepository iUsuarioRepository;

	@Override
	public void guardarUsuario(Usuario usuario) {
		String password = usuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		usuario.setPassword(bCryptPasswordEncoder.encode(password));
		iUsuarioRepository.save(usuario);
	}

	@Override
	public Usuario modificarUsuario(Usuario usuario) throws Exception {
		Usuario usuarioGuardado = buscarUsuario(usuario.getIdUsuario());
		mapearUsuario(usuario, usuarioGuardado);
		return iUsuarioRepository.save(usuarioGuardado);
	}
	public void mapearUsuario(Usuario desde, Usuario hacia) {
		hacia.setNombreReal(desde.getNombreReal());
		hacia.setApellidoReal(desde.getApellidoReal());
		hacia.setNombreUsuario(desde.getNombreUsuario());
		hacia.setTipoUsuario(desde.getTipoUsuario());
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return iUsuarioRepository.listarUsuarios();
	}

	@Override
	public Usuario buscarUsuario(long idUsuario) throws Exception {
		return iUsuarioRepository.findById(idUsuario).orElseThrow(()-> new Exception("El usuario no existe"));
	}

	@Override
	public void eliminarUsuario(long idUsuario) {
		iUsuarioRepository.deleteById(idUsuario);
	}

}

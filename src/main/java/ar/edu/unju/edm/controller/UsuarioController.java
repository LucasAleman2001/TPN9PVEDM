package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.modelo.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	Usuario usuario;
	
	@Autowired
	IUsuarioService iUsuarioService;
	
	@GetMapping("/nuevoUsuario")
	public String usuarioForm(Model model) {
		model.addAttribute("usuario", usuario);
		return "usuario-form";
	}
	
	@GetMapping("/guardarUsuario")
	public String guardarUsuario(@ModelAttribute Usuario usuario, Model model) {
		usuario.setApellidoReal(usuario.getApellidoReal());
		usuario.setNombreReal(usuario.getNombreReal());
		usuario.setNombreUsuario(usuario.getNombreUsuario());
		usuario.setPassword(usuario.getPassword());
		usuario.setTipoUsuario(usuario.getTipoUsuario());
		iUsuarioService.guardarUsuario(usuario);
		return "redirect:/usuario";
	}
	
	@GetMapping("/usuario")
	public String mostrarUsuarios(Model model) {
		model.addAttribute("usuario", iUsuarioService.listarUsuarios());
		return "usuario";
	}
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name="id") int idUsuario) throws Exception {
		try {
			iUsuarioService.eliminarUsuario(idUsuario);
		}catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		return "redirect:/usuario";
	}
	

	@GetMapping("/editarUsuario/{id}")
	public String modificarUsuario(Model model, @PathVariable(name="id") int idUsuario) throws Exception {
		iUsuarioService.buscarUsuario(idUsuario);
		model.addAttribute("editMode", "true");
		return "usuario-form";
	}
	
	@PostMapping("/postEditarUsuario")
	public String postEditarUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("editMode", "true");
		}else {
			try {
				System.out.println(usuario.getIdUsuario());
				iUsuarioService.modificarUsuario(usuario);
				model.addAttribute("usuarioD", usuario);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("usuario-form", usuario);
				model.addAttribute("editMode", "true");
			}
		}
		model.addAttribute("usuario", iUsuarioService.listarUsuarios());
		return "redirect:/usuario";
	}
	
	@GetMapping("/cancelarUsuario")
	public String cancelarEditar(ModelMap model) {
		return "redirect:/usuario";	
	}
	
}

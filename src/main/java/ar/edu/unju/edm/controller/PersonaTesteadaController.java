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

import ar.edu.unju.edm.modelo.PersonaTesteada;
import ar.edu.unju.edm.service.IPersonaTesteadaService;

@Controller
@RequestMapping
public class PersonaTesteadaController {
	
	@Autowired
	IPersonaTesteadaService iPersonaTesteadaService;
	
	@Autowired
	PersonaTesteada personaTesteada;
	
	@GetMapping("/nuevoPersonaTesteada")
	public String crearPersonaTesteada(Model model) {
		model.addAttribute("personaTesteada", personaTesteada);
		return "personaTesteada-form";
	}
	
	@GetMapping("/guardarPersonaTesteada")
	public String guardarPersonaTesteada(@ModelAttribute PersonaTesteada personaTesteada, Model model) {
		model.addAttribute("PersonaTesteada", personaTesteada);
		return "redirect:/personaTesteada";
	}
	
	@GetMapping("/mostrarPersonasTesteadas")
	public String mostrarPersonaTesteada(Model model) {
		model.addAttribute("personasTesteadas", iPersonaTesteadaService.listarPersonasTesteadas());
		return "personasTesteadas";
	}
	
	@GetMapping("/editarPersonaTesteada/{id}")
	public String editarPersonaTesteada(Model model, @PathVariable(name="id") int idPersonaTesteada) throws Exception{
		PersonaTesteada personaTesteadaEncontrado = iPersonaTesteadaService.buscarPersonaTesteada(idPersonaTesteada);
		model.addAttribute("personaTesteada", personaTesteadaEncontrado);
		model.addAttribute("EditMode", "true");
		return "personaTesteada-form";
	}
	
	@PostMapping("/postEditarPersonaTesteada")
	public String postEditarPersonaTesteada(@ModelAttribute("personaTesteada") PersonaTesteada personaTesteada, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("personaTesteada", personaTesteada);
			model.addAttribute("editMode", "true");
		}else {
			try {
				iPersonaTesteadaService.modificarPersonaTesteada(personaTesteada);
				model.addAttribute("personaTesteada", personaTesteada);
				model.addAttribute("editMode", "false");
				} catch (Exception e) {
				model.addAttribute("formPersonaTesteadaErrorMessage", e.getMessage());
				model.addAttribute("personaTesteada-form", personaTesteada);
				model.addAttribute("editMode", "true");
				}
		}
		return "redirect:/personaTesteada";
	}
	
	@GetMapping("/eliminarPersonaTesteada")
	public String eliminarPersonaTesteada(Model model, @PathVariable(name="id") int idPersonaTesteada) {
		try {
			iPersonaTesteadaService.eliminarPersonaTesteada(idPersonaTesteada);
			
			}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
			}
		
		return "redirect:/personaTesteada";		
	}
	
	@GetMapping("/cancelarPersonaTesteada")
	public String cancelarEditarPersonaTesteada(ModelMap model) {
		return "redirect:/personaTesteada";
	}
	
}

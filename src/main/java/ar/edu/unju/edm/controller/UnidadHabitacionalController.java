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

import ar.edu.unju.edm.modelo.UnidadHabitacional;
import ar.edu.unju.edm.service.IUnidadHabitacionalService;

@Controller
@RequestMapping
public class UnidadHabitacionalController {
	
	@Autowired
	IUnidadHabitacionalService iUnidadHabitacionalService;
	
	@Autowired
	UnidadHabitacional unidadHabitacional;
	
	@GetMapping("/nuevoUnidadHabitacional")
	public String crearUnidadHabitacional(Model model) {
		model.addAttribute("unidadHabitacional", unidadHabitacional);
		return "unidadHabitacional-form";
	}
	
	@GetMapping("/guardarUnidadHabitacional")
	public String guardarUnidadHabitacional(@ModelAttribute UnidadHabitacional unidadHabitacional, Model model) {
		model.addAttribute("unidadHabitacional", unidadHabitacional);
		return "redirect:/unidadHabitacional";
	}
	
	@GetMapping("/mostrarUnidadHabitacional")
	public String mostrarUnidadHabitacional(Model model) {
		model.addAttribute("unidadHabitacional", iUnidadHabitacionalService.listarUnidadesHabitacionales());
		return("unidadesHabitacionales");
	}
	
	@GetMapping("/editarUnidadHabitacional")
	public String editarUnidadHabitacional(Model model, @PathVariable(name="id") Long idUnidadHabitacional) throws Exception{
		UnidadHabitacional unidadHabitacionalEncontrado = iUnidadHabitacionalService.buscarUnidadHabitacional(idUnidadHabitacional);
		model.addAttribute("unidadHabitacional", unidadHabitacionalEncontrado);
		model.addAttribute("EditMode", "true");
		return "unidadHabitacional-form";
	}
	
	@PostMapping("/postEditarUnidadHabitacional")
	public String postEditarUnidadHabitacional(@ModelAttribute("unidadHabitacional") UnidadHabitacional unidadHabitacional, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("unidadHabitacional", unidadHabitacional);
			model.addAttribute("editMode", "true");
		}else {
			try {
				iUnidadHabitacionalService.modificarUnidadHabitacional(unidadHabitacional);
				model.addAttribute("unidadHabitacional", unidadHabitacional);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				model.addAttribute("formUnidadHabitacionalErrorMessage", e.getMessage());
				model.addAttribute("unidadHabitacional-form", unidadHabitacional);
				model.addAttribute("editMode", "true");
			}
		}
		return "redirect:/unidadHabitacional";
	}
	
	@GetMapping("/eliminarUnidadHabitacional/{id}")
	public String eliminarUnidadHabitacional(Model model, @PathVariable(name="id") Long idUnidadHabitacional) {
		try {
			iUnidadHabitacionalService.eliminarUnidadHabitacional(idUnidadHabitacional);
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return "redirect:/unidadHabitacional";		
	}
	
	@GetMapping("/cancelarUnidadHabitacional")
	public String cancelarEditarUnidadHabitacional(ModelMap model) {
		return "redirect:/unidadHabitacional"; 
	}
	
}

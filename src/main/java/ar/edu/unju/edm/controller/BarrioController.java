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

import ar.edu.unju.edm.modelo.Barrio;
import ar.edu.unju.edm.service.IBarrioService;

@Controller
@RequestMapping
public class BarrioController {

	@Autowired
	IBarrioService iBarrioService;
	
	@Autowired
	Barrio barrio;
	
	@GetMapping("/nuevoBarrio")
	public String crearBarrio(Model model) {
		model.addAttribute("barrio", barrio);
		return "barrio-form";
	}
	
	@GetMapping("/guardarBarrio")
	public String guardarBarrio(@ModelAttribute Barrio barrio, Model model) {
		model.addAttribute("barrio", barrio);
		return "redirect:/barrio";
	}
	
	@GetMapping("/editarBarrio/{id}")
	public String editarBarrio(Model model, @PathVariable(name="id") Long idBarrio) throws Exception {
		Barrio barrioEncontrado = iBarrioService.buscarBarrio(idBarrio);
		model.addAttribute("barrio", barrioEncontrado);
		model.addAttribute("editMode","true");
		return "barrio-form";
	}
	
	@PostMapping("/postEditarBarrio")
	public String postEditarBarrio(@ModelAttribute("barrio") Barrio barrio, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("barrio", barrio);
			model.addAttribute("editMode", "true");
		}else {
			try {
				iBarrioService.modificarBarrio(barrio);
				model.addAttribute("barrio", barrio);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				model.addAttribute("formBarrioErrorMessage", e.getMessage());
				model.addAttribute("barrio-form", barrio);
				model.addAttribute("editMode", "true");
			}
		}
		return "redirect:/barrio";
	}
	
	@GetMapping("/eliminarBarrio/{id}")
	public String eliminarBarrio(Model model, @PathVariable(name="id") Long idBarrio) {
		try {
			iBarrioService.eliminarBarrio(idBarrio);
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return "redirect:/barrio";		
	}
	
	@GetMapping("/cancelarBarrio")
	public String cancelarEditarBarrio(ModelMap model) {
		return "redirect:/barrio";		
	}
	
}

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

import ar.edu.unju.edm.modelo.RegistroTesteo;
import ar.edu.unju.edm.service.IRegistroTesteoService;

@Controller
@RequestMapping
public class RegistroTesteoController {
	
	@Autowired
	IRegistroTesteoService iRegistroTesteoService;
	
	@Autowired
	RegistroTesteo registroTesteo;
	
	@GetMapping("/nuevoRegistroTesteo")
	public String crearRegistroTesteo(Model model) {
		model.addAttribute("registroTesteo", registroTesteo);
		return "registroTesteo-form";
	}
	
	@GetMapping("/guardarRegistroTesteo")
	public String guardarRegistroTesteo(@ModelAttribute RegistroTesteo registroTesteo, Model model) {
		model.addAttribute("registroTesteo", registroTesteo);
		return "redirect:/registroTesteo";
	}
	
	@GetMapping("/mostrarRegistroTesteo")
	public String mostrarRegistroTesteo(Model model) {
		model.addAttribute("registroTesteo", registroTesteo);
		return "registroTesteo";
	}
	
	@GetMapping("/editarRegistroTesteo/{id}")
	public String editarRegistroTesteo(Model model, @PathVariable(name="id") Long idRegistroTesteo) throws Exception{
		RegistroTesteo registroTesteoGuardado = iRegistroTesteoService.buscarRegistroTesteo(idRegistroTesteo);
		model.addAttribute("registroTesteo", registroTesteoGuardado);
		model.addAttribute("editMode","true");
		return "registroTesteo-form";
	}
	
	@PostMapping("/postEditarRegistroTesteo")
		public String postEditarRegistroTesteo(@ModelAttribute("registroTesteo") RegistroTesteo registroTesteo, BindingResult result, ModelMap model) {
			if(result.hasErrors()) {
				model.addAttribute("registroTesteo", registroTesteo);
				model.addAttribute("editMode", "true");
			}else {
				try {
					iRegistroTesteoService.modificarRegistroTesteo(registroTesteo);
					model.addAttribute("registroTesteo", registroTesteo);
					model.addAttribute("editMode", "false");
					} catch (Exception e) {
					model.addAttribute("formRegistroTesteoErrorMessage", e.getMessage());
					model.addAttribute("registroTesteo-form", registroTesteo);
					model.addAttribute("editMode", "true");
					}
			}
			return "redirect:/registroTesteo";
		}
	
	@GetMapping("/eliminarRegistroTesteo/{id}")
	public String eliminarRegistroTesteo(Model model, @PathVariable(name="id") Long idRegistroTesteo) {
		try {
			iRegistroTesteoService.eliminarRegistroTesteo(idRegistroTesteo);
			
		}catch(Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
		}
		
		return "redirect:/registroTesteo";	
	}
	
	@GetMapping("/cancelarRegistroTesteo")
	public String cancelarEditarRegistroTesteo(ModelMap model) {
		return "redirect:/registroTesteo";
	}
	
}
package ar.edu.unju.edm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class AplicacionController implements ErrorController{
	
	private static final String PATH="/error";
	
	@Autowired
	IUsuarioService iUsuarioService;
	
	@GetMapping("/home")
	public String iniciarAplicacion(Model model) {
		return "index";
	}
	
	@GetMapping("/login")
	public String ingreso(Model model) {
		return "login";
	}
	
	@GetMapping("/logout")
    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
          
        return "redirect:/login?logout";
    }
	
	@RequestMapping(value=PATH)
	public String defaultErrorMessage() {
		return "error";
	}
	
	@Override
	public String getErrorPath() {
		return PATH;
	}
	
}

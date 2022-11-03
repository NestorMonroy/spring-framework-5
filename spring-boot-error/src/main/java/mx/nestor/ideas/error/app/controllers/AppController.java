package mx.nestor.ideas.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import mx.nestor.ideas.error.app.errors.UsuarioNoEncontradoException;
import mx.nestor.ideas.error.app.models.domain.Usuario;
import mx.nestor.ideas.error.app.models.services.IUsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/index")
	@SuppressWarnings("unused")
	public String index() {
		
		Integer valor = 100/0;
		//Integer valor = Integer.parseInt("10x");
		return "index";
	}
	
	@GetMapping("ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
	
		
		//Usuario usuario = usuarioService.obtenerPorId(id);
		
		/*
		if(usuario == null) {
			throw new UsuarioNoEncontradoException(id.toString());
			
		}*/
		
		Usuario usuario = usuarioService.obtenerPorIdOptional(id).orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		return "ver";
	}
}

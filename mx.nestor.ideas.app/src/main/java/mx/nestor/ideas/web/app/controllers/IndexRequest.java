package mx.nestor.ideas.web.app.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.nestor.ideas.web.app.models.Usuario;

@Controller
//@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@RequestMapping("/app")
public class IndexRequest {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;

	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Usuario01");
		usuario.setApellido("Apellido01");
		usuario.setEmail("abc@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		
		return "listar";
	}
	
	@ModelAttribute("usuarios") //Muestra en comun en todos los metodos
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Usuario01", "Apellido01", "abc01@correo.com"),
				new Usuario("Usuario02", "Apellido02", "abc02@correo.com"),
				new Usuario("Usuario03", "Apellido03", "abc03@correo.com"),
				new Usuario("Usuario04", "Apellido04", "abc04@correo.com"));
		
		return usuarios;
	}
}

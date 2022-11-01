package mx.nestor.ideas.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import mx.nestor.ideas.form.app.editors.NombreMayusculaEditor;
import mx.nestor.ideas.form.app.editors.PaisPropertyEditor;
import mx.nestor.ideas.form.app.editors.RolesEditor;
import mx.nestor.ideas.form.app.models.domain.Pais;
import mx.nestor.ideas.form.app.models.domain.Role;
import mx.nestor.ideas.form.app.models.domain.Usuario;
import mx.nestor.ideas.form.app.services.IPaisService;
import mx.nestor.ideas.form.app.services.IRoleService;
import mx.nestor.ideas.form.app.services.PaisServiceImpl;
import mx.nestor.ideas.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;
	
	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private PaisPropertyEditor paisEditor;
	
	@Autowired
	private RolesEditor roleEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		dateFormat.setLenient(false);
		
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true));
		
		//binder.registerCustomEditor(String.class, new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());
		binder.registerCustomEditor(Pais.class, "pais", paisEditor);
		binder.registerCustomEditor(Role.class, "roles", roleEditor);

	}
	
	@ModelAttribute("genero")
	public List<String> genero(){
		return Arrays.asList("Hombre", "Mujer");
	}
	
	
	@ModelAttribute("listaRoles")
	public List<Role> listaRoles(){
		return this.roleService.listar();
	}

	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("titulo ", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		usuario.setNombre("John");
		usuario.setHabilitar(true);
		usuario.setValorSecreto("lo que sea");
		usuario.setApellido("Doe");
		usuario.setIdentificador("13.456.789-K");
		usuario.setPais(new Pais(3, "CL", "Chile"));
		usuario.setRoles(Arrays.asList(new Role(2, "Usuario", "ROLE_USER")));

		return "form";
	}
	
	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
		return paisService.listar();
	}

	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString(){
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}
	
	
	
	@ModelAttribute("listaRolesMap")
	public Map<String, String> listaRolesMap() {
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERATOR", "Moderador");

		return roles;
	}
	
	
	/*
	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
		return Arrays.asList(
				new Pais(1, "ES", "España"), 
				new Pais(2, "MX", "México"),
				new Pais(3, "CL", "Chile"),
				new Pais(4, "AR", "Argentina"), 
				new Pais(5, "PE", "Perú"), 
				new Pais(6, "CO", "Colombia"),
				new Pais(7, "VE", "Venezuela"));
	}
	*/
	@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("España", "México", "Chile", "Argentina", "Perú", "Colombia", "Venezuela");
	}

	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("ES", "España");
		paises.put("MX", "México");
		paises.put("CL", "Chile");
		paises.put("AR", "Argentina");
		paises.put("PE", "Perú");
		paises.put("CO", "Colombia");
		paises.put("VE", "Venezuela");
		return paises;
	}

	
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		
		//validador.validate(usuario, result);
		
		model.addAttribute("titulo", "Resultado form");
		
		if(result.hasErrors()) {
			
			return "form";
		}
		
		model.addAttribute("usuario", usuario);
		System.out.println(usuario.getFechaNacimiento());
		status.setComplete();
		return "resultado";
	}
	
	
	/*
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
		
		model.addAttribute("titulo", "Resultado form");
		
		if(result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err ->{
				errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			model.addAttribute("error", errores);
			return "form";
		}
		
		model.addAttribute("usuario", usuario);

		return "resultado";
	}

	*/
	/*
	
	@PostMapping("/form")
	public String procesar(Usuario usuario, Model model) {
		
		model.addAttribute("titulo", "Resultado form");
		model.addAttribute("usuario", usuario);

		
		return "resultado";
	}*/
	
	/*
	@PostMapping("/form")
	public String procesar(Model model, 
			@RequestParam(name="username") String username,
			@RequestParam String password,
			@RequestParam String email) {
		
		Usuario usuario = new Usuario();
		usuario.setUsername(username);
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		model.addAttribute("titulo", "Resultado form");
		model.addAttribute("usuario", usuario);

		
		return "resultado";
	}*/
}

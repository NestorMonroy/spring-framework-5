package mx.nestor.ideas.web.app.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/app")
public class IndexController {
/*	
	@GetMapping({"/index", "/", "", "/home"})
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo", "Hola Nestor con ModelAndView");
		mv.setViewName("index");
	ssreturn mv;
	}
	/*
	public String index(Map<String,String> model) {
		model.put("titulo", "Hola Nestor con MAP");
		return "index";
	}*/
	
	/*
	public String index(ModelMap model) {
		model.addAttribute("titulo", "Hola Nestor");
		return "index";
	}
	*/
	/*public String index(Model model) {
		model.addAttribute("titulo", "Hola Nestor");
		return "index";
	}*/
	
	
}

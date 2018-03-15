package ua.karatnyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.karatnyk.domain.LoginRequest;

@Controller
public class BaseController {
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		model.addAttribute("loginModel", new LoginRequest());
		return "home";
	}

}

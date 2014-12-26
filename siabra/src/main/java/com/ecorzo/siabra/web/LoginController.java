package com.ecorzo.siabra.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("username", name);
		
		//return "main_page";
		return new ModelAndView("main_page", "model", model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login_page";
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login_page";

	}
	
	@RequestMapping(value = "/guide", method = RequestMethod.GET)
	public String guide(ModelMap model) {
		return "guide_page";
	}

}

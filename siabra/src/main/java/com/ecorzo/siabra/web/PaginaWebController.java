package com.ecorzo.siabra.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecorzo.siabra.service.PaginasWebManager;

@Controller
public class PaginaWebController {

	@Autowired
	private PaginasWebManager paginasManager;
	
	@RequestMapping(value = "/paginas", method = RequestMethod.GET)
	public ModelAndView printMisPaginasWeb(Model model, Principal principal){	
		return new ModelAndView("web_page", "model", model);
	}
	
}

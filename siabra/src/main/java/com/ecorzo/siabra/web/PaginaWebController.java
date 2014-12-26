package com.ecorzo.siabra.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.validator.routines.UrlValidator;

import com.ecorzo.siabra.domain.PaginasWeb;
import com.ecorzo.siabra.service.PaginasWebManager;

@Controller
public class PaginaWebController {

	@Autowired
	private PaginasWebManager paginasManager;
	
	@RequestMapping(value = "/paginas", method = RequestMethod.GET)
	public ModelAndView printMisPaginasWeb(ModelMap model, Principal principal){	
		String name = principal.getName();
		PaginasWeb paginas= paginasManager.getPaginasWeb(name);
		model= paginasToModel(paginas,  model);
		return new ModelAndView("web_page", "model", model);
	}
	
	@RequestMapping(value = "/paginas/registro", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	 public @ResponseBody
    ResponseEntity<String> registrarPaginasWeb(Principal principal, HttpServletRequest request) {
		UrlValidator urlValidator = new UrlValidator();
		JSONObject json= new JSONObject();
		String facebook=request.getParameter("facebook");
		String twitter=request.getParameter("twitter");
		String linkedin=request.getParameter("linkedin");
		String webPersonal=request.getParameter("webPersonal");
		String webProfesional=request.getParameter("webProfesional");
		String username=principal.getName();
		PaginasWeb paginas= new PaginasWeb();
		Boolean validar=true;
		if(urlValidator.isValid(facebook) && !facebook.isEmpty()){
			validar=false;
		}
		if(urlValidator.isValid(linkedin) && !linkedin.isEmpty()){
			validar=false;
		}
		if(urlValidator.isValid(twitter) && !twitter.isEmpty()){
			validar=false;
		}
		if(urlValidator.isValid(webPersonal) && !webPersonal.isEmpty()){
			validar=false;
		}
		if(urlValidator.isValid(webProfesional) && !webProfesional.isEmpty()){
			validar=false;
		}
		if(validar){
			paginas.setFacebook(facebook);
			paginas.setLinkedin(linkedin);
			paginas.setTwitter(twitter);
			paginas.setWebPersonal(webPersonal);
			paginas.setWebProfesional(webProfesional);
			paginas.setUsername(username);
			paginasManager.guardarPaginasWeb(paginas);
			try {
				json.accumulate("Status","Exito");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
			try {
				json.accumulate("Status","Error");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

        HttpHeaders responseHeaders = new HttpHeaders(); 
        responseHeaders.add("Content-Type", "application/json; charset=utf-8"); 
        return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.CREATED);
	}
	
	private ModelMap paginasToModel(PaginasWeb paginas, ModelMap model){
		model.addAttribute("facebook", paginas.getFacebook());
		model.addAttribute("twitter", paginas.getTwitter());
		model.addAttribute("linkedin", paginas.getLinkedin());
		model.addAttribute("webProfesional", paginas.getWebProfesional());
		model.addAttribute("webPersonal", paginas.getWebPersonal());
		return model;
	}
	
}

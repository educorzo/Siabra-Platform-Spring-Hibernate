package com.ecorzo.siabra.web;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.UrlValidator;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ecorzo.siabra.domain.DatosPersonales;
import com.ecorzo.siabra.domain.User;
import com.ecorzo.siabra.service.DatosPersonalesManager;
import com.ecorzo.siabra.service.UsuarioManager;

@Controller
public class DatosPersonalesController {

	@Autowired
	private DatosPersonalesManager datosPersonalesM;
	@Autowired
	private UsuarioManager usuarioM;
	
	@RequestMapping(value = "/datos", method = RequestMethod.GET)
	public ModelAndView printDatosPersonales(ModelMap model, Principal principal) {
		String name = principal.getName();
		DatosPersonales datos=datosPersonalesM.getDatosPersonales(name);
		User usuario=usuarioM.getUsuario(name);
		model=datosToModel(usuario, datos, model);
		return new ModelAndView("datos_page", "model", model);
	}
	/*
	@RequestMapping(value = "/datos/registro", method = RequestMethod.POST)
	public String registrarDatosPersonales(Principal principal, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String name = principal.getName();
		DatosPersonales datos=requestToDatos( request);
		User usuario=requestToUser(request, usuarioM.getUsuario(name));
		usuarioM.guardarUsuario(usuario);
		datos.setUsername(name);
		datosPersonalesM.guardarDatosPersonales(datos);
		return "datos_page";
	}*/
	
	@RequestMapping(value = "/datos/registro", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	 public @ResponseBody ResponseEntity<String> registrarDatosPersonales(Principal principal, HttpServletRequest request) {
		EmailValidator emailValidator = EmailValidator.getInstance();//singleton
		JSONObject json= new JSONObject();
		String name = principal.getName();
		DatosPersonales datos=requestToDatos( request);
		User usuario=requestToUser(request, usuarioM.getUsuario(name));
		Boolean validar=true;
		if(!emailValidator.isValid(usuario.getEmail()) && !usuario.getEmail().isEmpty()){
			validar=false;
		}
		if(validar){
			usuarioM.guardarUsuario(usuario);
			datos.setUsername(name);
			datosPersonalesM.guardarDatosPersonales(datos);
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
	
	private ModelMap datosToModel(User usuario, DatosPersonales datos, ModelMap model){
		model.addAttribute("nombre", usuario.getFirst_name());
		model.addAttribute("apellidos", usuario.getLast_name());
		model.addAttribute("email", usuario.getEmail());
		model.addAttribute("comentario", datos.getComentario());
		model.addAttribute("direccion", datos.getDireccion());
		model.addAttribute("dni", datos.getDNI());
		model.addAttribute("empresa",datos.getEmpresa());
		model.addAttribute("estatus",datos.getEstatus());
		model.addAttribute("nacimiento",datos.getNacimiento());
		model.addAttribute("empresa",datos.getPais());
		model.addAttribute("permisos",datos.getPermisos());
		model.addAttribute("profesion",datos.getProfesion());
		model.addAttribute("telefono",datos.getTelefono());
		model.addAttribute("username",datos.getUsername());
		return model;
	}
	
	private DatosPersonales requestToDatos(HttpServletRequest request) {
		DatosPersonales datos = new DatosPersonales();
		datos.setComentario((String) request.getParameter("comentario"));
		datos.setDireccion((String) request.getParameter("direccion"));
		datos.setDNI((String) request.getParameter("dni"));
		datos.setEmpresa((String) request.getParameter("empresa"));
		datos.setEstatus((String) request.getParameter("estatus"));
		Date date= new Date();
		try {
			if( request.getParameter("nacimiento")!=""){
				date = new SimpleDateFormat("dd-MM-yyyy").parse( request.getParameter("nacimiento"));
			}
			
			datos.setNacimiento(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datos.setPais((String) request.getParameter("pais"));
		datos.setProfesion((String) request.getParameter("profesion"));
		datos.setTelefono((String) request.getParameter("telefono"));
		return datos;
	}
	
	private User requestToUser(HttpServletRequest request, User usuario){
		//AL introducir usuario, mantiene el mismo password, enabled y el resto de informacion
		usuario.setFirst_name((String) request.getParameter("name"));
		usuario.setLast_name((String) request.getParameter("lastName"));
		usuario.setEmail((String) request.getParameter("email"));
		return usuario;
	}
	
}

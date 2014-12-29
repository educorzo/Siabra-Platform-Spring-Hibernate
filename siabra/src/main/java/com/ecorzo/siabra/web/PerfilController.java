package com.ecorzo.siabra.web;

import java.security.Principal;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.ecorzo.siabra.domain.Perfil;
import com.ecorzo.siabra.service.PerfilManager;

@Controller
public class PerfilController {
	@Autowired
	private PerfilManager perfilManager;

	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public ModelAndView printPaginaPerfil(ModelMap model, Principal principal) {
		 String name = principal.getName();
		 Perfil perfil = perfilManager.getPerfil(name);
		 ModelAndView vista;
		 if (perfil== null) {
			vista=new ModelAndView("perfil_page", "model", model);
		 }
		 else{
			 model.addAttribute("list",perfil.getPermisosArray());
			 model.addAttribute("description", perfil.getDescripcion());
			 model.addAttribute("codigo",perfil.getCodigo());
			 vista= new ModelAndView("perfilCreado_page","model",model);
		 }
		return vista;
	}

	@RequestMapping(value = "/perfil/eliminar", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public  @ResponseBody ResponseEntity<String> eliminarPerfil(Principal principal, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		String name = principal.getName();
		if(perfilManager.eliminarPerfil(name)){
			try {
				json.accumulate("Status", "Exito");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
			try {
				json.accumulate("Status", "Error");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<String>(json.toString(), responseHeaders,HttpStatus.CREATED);	
	}
	
	@RequestMapping(value = "/perfil/registro", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> registrarPerfil(Principal principal, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		String name = principal.getName();
		Perfil perfil = new Perfil();
		String permisos = request.getParameter("permisos");
		String descripcion = request.getParameter("descripcion");
		if (descripcion.length() <= 200 && permisos.length() <= 17) {
			perfil.setDescripcion(descripcion);
			perfil.setPermisos(permisos);
			UUID id = UUID.randomUUID();
			perfil.setCodigo(id.toString().substring(0, 9));
			perfil.setUsername(name);
			perfilManager.guardarPerfil(perfil);
			try {
				json.accumulate("Status", "Exito");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			try {
				json.accumulate("Status", "Error");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<String>(json.toString(), responseHeaders,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/perfil/eliminar", method = RequestMethod.POST)
	public String registrarDatosPersonales(Principal principal, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String name = principal.getName();
		
		return "datos_page";
	}

}//End of class

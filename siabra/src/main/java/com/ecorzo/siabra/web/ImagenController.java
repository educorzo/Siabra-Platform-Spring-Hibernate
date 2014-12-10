package com.ecorzo.siabra.web;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ecorzo.siabra.domain.Imagen;
import com.ecorzo.siabra.service.ImagenManager;

@Controller
public class ImagenController {

	@Autowired
	private ImagenManager imagenManager;
	@Autowired
	private MultipartResolver multipartResolver;

	@RequestMapping(value = "/imagen", method = RequestMethod.GET)
	public ModelAndView printPaginaImagen(ModelMap model, Principal principal) {
		String name = principal.getName();
		Imagen imagen = imagenManager.getImagen(name);
		if (imagen == null) {
			model.addAttribute("Imagen", false);
		}
		return new ModelAndView("imagen_page", "model", model);
	}

	@RequestMapping(value = "/imagen/registro", method = RequestMethod.POST)
	public String registrarImagen(Principal principal,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String name = principal.getName();

		Imagen imagen = imagenManager.getImagen(name);
		if (imagen == null)
			imagen = new Imagen();
		imagen.setUsername(name);
		try {
			MultipartFile sfile = file;
			byte[] lista = sfile.getBytes().clone();
			imagen.setImagen(lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String targetId= imagenManager.enviarAVuforia(imagen);
		if (targetId!=null && !targetId.isEmpty() ) { //FALTA UN ELSE POR SI NO SE PUEDE SUBIR IMAGEN
			imagen.setTarget_id(targetId);
			imagenManager.guardarImagen(imagen);
		}
		return "imagen_page";
	}

}

package com.ecorzo.siabra.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecorzo.siabra.domain.User;
import com.ecorzo.siabra.service.UsuarioManager;


@Controller
public class RegistroController {
	@Autowired
	@Qualifier("authenticationManager")
	protected AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioManager gestionUsuario;
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public String registro( HttpServletRequest request, HttpServletResponse response) {
		String hola= (String) request.getParameter("username");
		User entity= new User();
		entity.setUsername((String) request.getParameter("username"));
		entity.setEmail((String) request.getParameter("email"));
		String p=(String) request.getParameter("password1");
		String p2=(String) request.getParameter("password2");
		if((String) request.getParameter("password1")==(String) request.getParameter("password2")){
			entity.setPassword((String) request.getParameter("password1"));
			gestionUsuario.guardarUsuario(entity);
			authenticateUserAndSetSession( entity, request);
		}
		System.out.printf(hola);
		return "main_page";

	}
	 private void authenticateUserAndSetSession(User user, HttpServletRequest request)
		    {
		        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
		                user.getUsername(), user.getPassword());

		        // generate session if one doesn't exist
		        request.getSession();

		        token.setDetails(new WebAuthenticationDetails(request));
		        Authentication authenticatedUser = authenticationManager.authenticate(token);

		        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		    }

}

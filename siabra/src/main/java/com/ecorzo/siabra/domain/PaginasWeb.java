package com.ecorzo.siabra.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="PaginasWeb")
public class PaginasWeb implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="username")
	private String username;
	@Column(name="facebook")
	private String facebook;
	@Column(name="twitter")
	private String twitter;
	@Column(name="linkedin")
	private String linkedin;
	@Column(name="webPersonal")
	private String webPersonal;
	@Column(name="webProfesional")
	private String webProfesional;
	
	public PaginasWeb(){
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getWebPersonal() {
		return webPersonal;
	}
	public void setWebPersonal(String webPersonal) {
		this.webPersonal = webPersonal;
	}
	public String getWebProfesional() {
		return webProfesional;
	}
	public void setWebProfesional(String webProfesional) {
		this.webProfesional = webProfesional;
	}
}

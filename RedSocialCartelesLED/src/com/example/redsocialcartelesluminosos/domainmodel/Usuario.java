package com.example.redsocialcartelesluminosos.domainmodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id; //para persistir con Hibernate
	
	private String username;
	private String mail;
	private int cuit_cuil;
	private String contraseña;
	private int puntosPrestigio;
	
	@OneToMany(mappedBy = "publicador", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Publicacion> publicaciones = new ArrayList<Publicacion>();
	
	public String getUsername(){
		return username;
	}
	
	public String getMail(){
		return mail;
	}
	
	public int getCuit_cuil(){
		return cuit_cuil;
	}
	
	public String getContraseña(){
		return contraseña;
	}
	
	public int getPuntosPrestigio(){
		return puntosPrestigio;
	}
	
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public void setMail(String mail){
		this.mail=mail;
	}
	
	public void setCuit_cuil(int cuit){
		this.cuit_cuil=cuit;
	}
	
	public void setContraseña(String contraseña){
		this.contraseña=contraseña;
	}
	
	public void setPuntosPrestigio(int puntosPrestigio){
		this.puntosPrestigio=puntosPrestigio;
	}
	
}

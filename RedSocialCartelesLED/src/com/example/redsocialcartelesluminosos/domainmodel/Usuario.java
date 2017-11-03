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
	private String contrase�a;
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
	
	public String getContrase�a(){
		return contrase�a;
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
	
	public void setContrase�a(String contrase�a){
		this.contrase�a=contrase�a;
	}
	
	public void setPuntosPrestigio(int puntosPrestigio){
		this.puntosPrestigio=puntosPrestigio;
	}
	
}

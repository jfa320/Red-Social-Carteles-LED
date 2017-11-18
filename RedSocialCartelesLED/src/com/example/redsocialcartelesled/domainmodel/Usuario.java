package com.example.redsocialcartelesled.domainmodel;

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
	private Long cuit_cuil;
	private String contraseña;
	private int puntosPrestigio;
	private boolean esPrestigioso;
	
	@OneToMany(mappedBy = "publicador", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Publicacion> publicaciones = new ArrayList<Publicacion>();
	
	public String getUsername(){
		return username;
	}
	
	public String getMail(){
		return mail;
	}
	
	public Long getCuit_cuil(){
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
	
	public void setCuit_cuil(Long cuit){
		this.cuit_cuil=cuit;
	}
	
	public void setContraseña(String contraseña){
		this.contraseña=contraseña;
	}
	
	public void setPuntosPrestigio(int puntosPrestigio){
		this.puntosPrestigio=puntosPrestigio;
	}
	

	
	public void setEsPrestigioso(boolean esPrestigioso){
		this.esPrestigioso=esPrestigioso;
	}
	
	public boolean getEsPrestigioso(){
		return this.esPrestigioso;
	}
	public void setId(Long id){ //metodo para usar harcodeo publicarpost
		this.id=id;
	}
	public List<Publicacion> getPublicaciones(){
		return this.publicaciones;
	}
}

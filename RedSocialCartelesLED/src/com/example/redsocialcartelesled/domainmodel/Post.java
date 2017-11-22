package com.example.redsocialcartelesled.domainmodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Post extends Publicacion {
	
	private String cuerpo;
	private int popularidad;
	
	@OneToMany( fetch=FetchType.EAGER ,mappedBy = "postCorrespondiente", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<Calificacion> calificaciones=new ArrayList<Calificacion>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Imagen img;
	
	public String getCuerpo(){
		return this.cuerpo;
	}
	public int getPopularidad(){
		return this.popularidad;
	}
	public Imagen getImg(){
		return this.img;
	}
	
	public void setCuerpo(String cuerpo){
		this.cuerpo=cuerpo;
	}
	public void setPopularidad(int popularidad){
		this.popularidad=popularidad;
	}
	public void setImg(Imagen img){
		this.img=img;
	}
	
	public void setCalificaciones(ArrayList<Calificacion> calificaciones){
		this.calificaciones=calificaciones;
	}
	public  List<Calificacion> getCalificaciones(){
		return calificaciones;
		
	}
	
	
	
}

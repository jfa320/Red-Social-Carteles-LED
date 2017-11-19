package com.example.redsocialcartelesled.domainmodel;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;



@Entity
public class Post extends Publicacion {
	
	private String cuerpo;
	private int popularidad;
	private ArrayList<Calificacion> calificaciones;
	
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
	public  ArrayList<Calificacion> getCalificaciones(){
		return calificaciones;
	}
	
	
	
}

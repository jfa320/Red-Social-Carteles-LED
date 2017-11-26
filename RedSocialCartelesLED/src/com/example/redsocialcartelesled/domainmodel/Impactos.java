package com.example.redsocialcartelesled.domainmodel;

public class Impactos extends Publicacion {
	private String texto;
	private int popularidad;
	
	public String getTexto(){
		return texto;
	}
	public int getPopularidad(){
		return popularidad;
	}
	public void setTexto(String texto){
		this.texto=texto;
	}
	
	public void setPopularidad(int popularidad){
		this.popularidad=popularidad;
	}
}

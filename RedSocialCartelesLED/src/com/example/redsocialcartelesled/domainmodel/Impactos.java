package com.example.redsocialcartelesled.domainmodel;

public class Impactos extends Publicacion {
	private String texto; //limite 100 caracteres
	private int popularidad;//debe ser mayor a 10000 votos para ser publicado en carteles
	
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

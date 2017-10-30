package com.example.redsocialcartelesluminosos.domainmodel;

public class Post extends Publicacion {
	private String cuerpo;
	private int popularidad;
	private Imagen img=null;
	
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
	
	
	
	
	
}

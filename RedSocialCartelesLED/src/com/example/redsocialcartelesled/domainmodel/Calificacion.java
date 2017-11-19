package com.example.redsocialcartelesled.domainmodel;

public class Calificacion {
	private int nota; //de 1 a 5 (ver forma de restringir)
	private Post postCorrespondiente;
	
	public void setNota(int nota){
		this.nota=nota;
	}
	
	public int getNote(){
		return this.nota;
	}
	
	public void setPostCorrespondiente(Post post){
		this.postCorrespondiente=post;
	}
	 public Post getPostCorrespondiente(){
		 return this.postCorrespondiente;
	 }
}

package com.example.redsocialcartelesled.domainmodel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Calificacion {
	@Id
	@GeneratedValue
	private Long id; //para persistir con Hibernate
	private int nota; 
	@ManyToOne(cascade = CascadeType.MERGE)
	private Post postCorrespondiente;
	
	public void setNota(int nota){
		this.nota=nota;
	}
	
	public int getNota(){
		return this.nota;
	}
	
	public void setPostCorrespondiente(Post post){
		this.postCorrespondiente=post;
	}
	 public Post getPostCorrespondiente(){
		 return this.postCorrespondiente;
	 }
}

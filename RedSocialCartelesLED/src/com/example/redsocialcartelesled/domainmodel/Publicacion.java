package com.example.redsocialcartelesled.domainmodel;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Publicacion {
	@Id
	@GeneratedValue
	private Long id; //para persistir con Hibernate
	
	private Date fechaYHoraCreacion;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Usuario publicador;
	
	public Date getFechaHoraCreacion(){
		return fechaYHoraCreacion;
	}
	
	public void setFechaHoraCreacion(Date fechaYHoraCreacion){
		this.fechaYHoraCreacion=fechaYHoraCreacion;
	}
	
	public Usuario getPublicador(){
		return publicador;
	}
	public void setPublicador(Usuario publicador){
		this.publicador=publicador;
	}
	
}

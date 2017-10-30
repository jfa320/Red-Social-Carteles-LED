package com.example.redsocialcartelesluminosos.domainmodel;

import java.util.Date;

public class Publicacion {

	private Date fechaYHoraCreacion;
	
	public Date getFechaHoraCreacion(){
		return fechaYHoraCreacion;
	}
	
	public void setFechaHoraCreacion(Date fechaYHoraCreacion){
		this.fechaYHoraCreacion=fechaYHoraCreacion;
	}
}

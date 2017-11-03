package com.example.redsocialcartelesled.domainmodel;

import java.util.Date;

public class ContenidoMultimedia {
	private String URLVideo;
	private Date fechaYHoraCreacion;
	
	public String getURLVideo(){
		return this.URLVideo;
	}
	public Date getfechaYHoraCreacion(){
		return this.fechaYHoraCreacion;
	}
	public void setURLVideo(String URL){
		this.URLVideo=URL;
	}
	public void setFechaYHoraCreacion(Date fechaYHoraCreacion){
		this.fechaYHoraCreacion=fechaYHoraCreacion;
	}
	
}

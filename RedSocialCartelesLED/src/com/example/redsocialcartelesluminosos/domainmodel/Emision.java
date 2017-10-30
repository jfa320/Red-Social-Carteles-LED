package com.example.redsocialcartelesluminosos.domainmodel;

import java.util.Date;

public class Emision {
	private Date inicioEmision;
	private int cantidadPostMostrados;
	private int duracionPostMostradosEnSegundos;
	private int duracionEmisionEnMinutos;
	
	public Date getInicioEmision(){
		return this.inicioEmision;
	}
	public int getCantidadPostMostrados(){
		return this.cantidadPostMostrados;
	}
	public int getDuracionPostMostradosEnSegundos(){
		return this.duracionPostMostradosEnSegundos;
	}
	public int getDuracionEmisionEnMinutos(){
		return this.duracionEmisionEnMinutos;
	}
	
	public void setInicioEmision(Date inicio){
		this.inicioEmision=inicio;
	}
	public void setCantidadPostMostrados(int cantidad){
		this.cantidadPostMostrados=cantidad;
	}
	public void setDuracionPostMostradosEnSegundos(int duracion){
		this.duracionPostMostradosEnSegundos=duracion;
	}
	public void setDuracionEmisionEnMinutos(int duracion){
		this.duracionEmisionEnMinutos=duracion;
	}
	
}
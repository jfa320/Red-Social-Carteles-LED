package com.example.redsocialcartelesled.domainmodel;

import java.util.ArrayList;
import java.util.Date;

public class Emision {
	private Date inicioEmision;
	private int cantidadPostMostrados;
	private int duracionPostMostradosEnSegundos;
	private int duracionEmisionEnMinutos;
	private ArrayList<Publicacion> publicacionesEmitir;
	private ArrayList<ContenidoMultimedia> multimediaEmitir;
	
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
	
	public void setPublicacionesEmitir(ArrayList<Publicacion> publicacionesEmitir){
		this.publicacionesEmitir=publicacionesEmitir;
	}
	public void setMultimediaEmitir(ArrayList<ContenidoMultimedia> multimediaEmitir){
		this.multimediaEmitir=multimediaEmitir;
	}
	public ArrayList<Publicacion> getPublicacionesEmitir(){
		return this.publicacionesEmitir;
	}
	public ArrayList<ContenidoMultimedia> getmultimediaEmitir(){
		return this.multimediaEmitir;
	}
	
}
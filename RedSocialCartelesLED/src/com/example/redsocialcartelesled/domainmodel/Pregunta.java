package com.example.redsocialcartelesled.domainmodel;

import java.util.ArrayList;

public class Pregunta {
	private String cuerpo;
	private ArrayList<Respuesta> respuestasPosibles; //el array contiene opciones de respuestas
	
	public String getCuerpo(){
		return cuerpo;
	}
	public ArrayList<Respuesta> getRespuestasPosibles(){
		return respuestasPosibles;
	}
	
	public void setCuerpo(String cuerpo){
		this.cuerpo=cuerpo;
	}
	public void setRespuesta(ArrayList<Respuesta> respuesta){
		this.respuestasPosibles=respuesta;
	}
	
	
	
}

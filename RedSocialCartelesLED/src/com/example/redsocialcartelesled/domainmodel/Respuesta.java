package com.example.redsocialcartelesled.domainmodel;

public class Respuesta {
	private String respuesta; //debe coincidir con las del array de pregunta
	private Pregunta preguntaAResponder;
	
	public void setRespuesta(String respuesta){
		this.respuesta=respuesta;
	}
	public String getRespuesta(){
		return this.respuesta;
	}
	public void setPregunta(Pregunta pregunta){
		this.preguntaAResponder=pregunta;
	}
	public Pregunta getPreguntaAResponder(){
		return this.preguntaAResponder;
	}
}

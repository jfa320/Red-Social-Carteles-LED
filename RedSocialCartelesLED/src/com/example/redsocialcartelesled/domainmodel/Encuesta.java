package com.example.redsocialcartelesled.domainmodel;

import java.util.ArrayList;

public class Encuesta extends Publicacion {
	private int cantParticipantes;
	private ArrayList<Pregunta> preguntas;
	
	public int getCantParticipantes(){
		return this.cantParticipantes;
	}
	public ArrayList<Pregunta> getPreguntas(){
		return preguntas;
	}
	
	public void setCantParticipantes(int cantidad){
		this.cantParticipantes=cantidad;
	}
	
	public void setPreguntas(ArrayList<Pregunta> preguntas){
		this.preguntas=preguntas;
	}
	
	
	
	
}

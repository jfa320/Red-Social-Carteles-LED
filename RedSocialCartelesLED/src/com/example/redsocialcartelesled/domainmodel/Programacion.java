package com.example.redsocialcartelesled.domainmodel;

import java.util.ArrayList;

public class Programacion {
	private ArrayList<Emision> programacion;
	
	public void setProgramacion( ArrayList<Emision> programacion){
		this.programacion=programacion;
	}
	
	public  ArrayList<Emision> getProgramacion(){
		return  this.programacion;
	}
	
}

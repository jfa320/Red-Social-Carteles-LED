package com.example.redsocialcartelesluminosos.domainmodel;

public class Administrador {
	private int codigo;
	private int contraseña;
	
	public int getCodigo(){
		return this.codigo;
	}
	public int getContraseña(){
		return this.contraseña;
	}
	public void setCodigo(int codigo){
		this.codigo=codigo;
	}
	public void setContraseña(int contraseña){
		this.contraseña=contraseña;
	}
	
}

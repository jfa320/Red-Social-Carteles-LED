package com.example.redsocialcartelesluminosos.domainmodel;

import java.util.Date;

public class TarjetaDeCredito {
	private int numeroTarjeta;
	private int codigoSeguridad;
	private String titular;
	private Date fechaVencimiento;
	
	
	public int getNumeroTarjeta(){
		return this.numeroTarjeta;
	}
	public int getCodigoSeguridad(){
		return this.codigoSeguridad;
	}
	public String getTitular(){
		return this.titular;
	}
	public Date getFechaVencimiento(){
		return this.fechaVencimiento;
	}
	
	
	public void setNumeroTarjeta(int numero){
		this.numeroTarjeta=numero;
	}
	public void setCodigoSeguridad(int codigo){
		this.codigoSeguridad=codigo;
	}
	public void setTitular(String titular){
		this.titular=titular;
	}
	public void setFechaVencimiento(Date fecha){
		this.fechaVencimiento=fecha;
	}

}

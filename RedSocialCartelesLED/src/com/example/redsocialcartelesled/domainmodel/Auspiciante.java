package com.example.redsocialcartelesled.domainmodel;

public class Auspiciante {
	private String razonSocial;
	private AvisoPublicitario aviso;
	private TarjetaDeCredito tarjeta;
	
	public String getRazonSocial(){
		return razonSocial;
	}
	public AvisoPublicitario getAviso(){
		return aviso;
	}
	public TarjetaDeCredito getTarjeta(){
		return tarjeta;
	}
	
	public void setRazonSocial(String razonSocial){
		this.razonSocial=razonSocial;
	}
	public void setAviso(AvisoPublicitario aviso){
		this.aviso=aviso;
	}
	public void setTarjeta(TarjetaDeCredito tarjeta){
		this.tarjeta=tarjeta;
	}
	

}

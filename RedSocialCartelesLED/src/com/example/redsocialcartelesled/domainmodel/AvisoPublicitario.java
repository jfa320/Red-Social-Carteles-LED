package com.example.redsocialcartelesled.domainmodel;

public class AvisoPublicitario {
	private String URLAviso;
	private boolean pagado;
	
	public String getURLAviso(){
		return this.URLAviso;
	}
	public boolean getPagado(){
		return pagado;
	}
	
	public void setURLAviso(String URL){
		this.URLAviso=URL;
	}
	public void setPagado(boolean pagado){
		this.pagado=pagado;
	}
	
}

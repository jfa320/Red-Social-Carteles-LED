package com.example.redsocialcartelesled.presentacion;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public class creacionPost extends VerticalLayout implements View {

	public static final String NAME = "";

	public creacionPost(){
		
		Label mensaje=new Label("Expresa tus pensamientos!");
		mensaje.setSizeFull();
		
		TextField campo=new TextField();
		campo.setMaxLength(300); //limitar el maximo de caracteres admitidos
		
		HorizontalLayout horLay=new HorizontalLayout();
		Button subirImg=new Button("Subir Imagen");
		Button publicar=new Button("Publicar");
		
		horLay.addComponent(subirImg);
		horLay.addComponent(publicar);
		horLay.setSpacing(true);
		
		campo.setHeight(125, Unit.PIXELS);
		campo.setWidth(300, Unit.PIXELS);
		
		setSpacing(true);
		addComponent(mensaje);
		addComponent(campo);
		addComponent(horLay);
		
		
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}

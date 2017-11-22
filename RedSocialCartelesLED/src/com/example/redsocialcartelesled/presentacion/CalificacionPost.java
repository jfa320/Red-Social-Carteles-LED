package com.example.redsocialcartelesled.presentacion;

import com.example.redsocialcartelesled.services.ServicioPublicadorUsuario;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class CalificacionPost extends FormLayout implements View {

	
	protected static final String NAME = "";
	private ServicioPublicadorUsuario servicioPublicadorUsuario=new ServicioPublicadorUsuario();
	 

	public CalificacionPost(){
		TextField area=new TextField();
		Label label=new Label("Califica el post!");
		VerticalLayout verLay=new VerticalLayout();
		Button aceptar=new Button("Aceptar");
		
		area.setValue(servicioPublicadorUsuario.levantarUltimoPost().getCuerpo());
		area.setReadOnly(true);
		
		
		OptionGroup group = new OptionGroup("Calificacion");
		group.addItems("1", "2", "3","4","5");
		group.addStyleName("horizontal");
		
		verLay.setSpacing(true);
		verLay.addComponent(label);
		verLay.addComponent(area);
		verLay.addComponent(group);
		verLay.setSpacing(true);
		verLay.addComponent(aceptar);
		this.addComponent(verLay);
	
		this.setSpacing(true);
		
		
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}

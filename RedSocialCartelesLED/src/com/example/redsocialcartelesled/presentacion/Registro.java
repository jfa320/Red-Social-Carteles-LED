package com.example.redsocialcartelesled.presentacion;

import com.example.redsocialcartelesled.domainmodel.Usuario;

import com.example.redsocialcartelesled.services.ServicioUsuario;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;

import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

import com.vaadin.ui.Button.ClickEvent;


public class Registro extends FormLayout implements View {

	protected static final String NAME = "";
	private FormLayout form = new FormLayout();
	private Label mensajeinicio= new Label("REGISTRATE");
	private TextField username = new TextField("USUARIO");
	private TextField mail = new TextField("CORREO ELECTR�NICO");
	private TextField contrase�a = new TextField("CONTRASE�A");
	private TextField cuit_cuil = new TextField("CUIT O CUIL");
	private Button aceptar=new Button("ACEPTAR");
	private BeanFieldGroup<Usuario> formFieldBindings;
	private ServicioUsuario servicioUsuario=new ServicioUsuario();
	
	private Usuario usuario=new Usuario();

	public Registro(){
		
		construirLayout();
		formFieldBindings =BeanFieldGroup.bindFieldsBuffered(usuario, this);

		
		
		aceptar.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					formFieldBindings.commit();
				} catch (CommitException e) {
					e.printStackTrace();
				}
				
				servicioUsuario.registrar(usuario);
					
			}
		});
		
		
	}
	
	private void construirLayout(){
		
		
		
		form.addComponent(mensajeinicio);
		form.addComponent(username);
		form.addComponent(mail);
		form.addComponent(contrase�a);
		form.addComponent(cuit_cuil);
		
		
		addComponent(form);
	
		addComponent(aceptar);
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
package com.example.redsocialcartelesled.presentacion;

import com.example.redsocialcartelesled.domainmodel.Usuario;
import com.example.redsocialcartelesled.services.ServicioPublicadorUsuario;
import com.example.redsocialcartelesled.services.ServicioUsuario;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;


public class Logueo extends FormLayout implements View {

	protected static final String NAME = "";
	private FormLayout form = new FormLayout();
	private Label mensajeinicio= new Label("INICIO DE SESION");
	private TextField username = new TextField("USUARIO");
	private TextField contraseña = new TextField("CONTRASEÑA");
	private HorizontalLayout horLay=new HorizontalLayout();
	private Label mensajeregistro= new Label("AÚN NO TIENES CUENTA??");
	private Button registro=new Button("REGISTRATE!!");
	private Button aceptar=new Button("INICIAR SESION");
	private ServicioUsuario servicioUsuario=new ServicioUsuario();
	private Usuario usuario=new Usuario();
	private BeanFieldGroup<Usuario> formFieldBindings;
	public Logueo(){
		
		
		
		construirLayout();

		formFieldBindings =BeanFieldGroup.bindFieldsBuffered(usuario, this);
		
		
		registro.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(Registro.NAME);
				
			}
		});
		
		aceptar.addClickListener(new Button.ClickListener() {
		
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					formFieldBindings.commit();
				} catch (CommitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(servicioUsuario.login(usuario)){
					getUI().getNavigator().navigateTo(CreacionPost.NAME);
				}
				
			}
		});
		
	
	}
	
	private void construirLayout(){
		
		form.addComponent(mensajeinicio);
		form.addComponent(username);
		form.addComponent(contraseña);
		
		horLay.addComponent(mensajeregistro);
		horLay.addComponent(registro);
		horLay.setSpacing(true);
		
		addComponent(form);
		
		addComponent(aceptar);
		
		addComponent(horLay);
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}

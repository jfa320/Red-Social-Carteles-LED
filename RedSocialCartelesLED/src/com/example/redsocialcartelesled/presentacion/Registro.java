package com.example.redsocialcartelesled.presentacion;

import com.example.redsocialcartelesled.domainmodel.Usuario;
import com.example.redsocialcartelesled.services.ServicioUsuario;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;


public class Registro extends FormLayout implements View {

	protected static final String NAME = "registro";
	private FormLayout form = new FormLayout();
	private Label mensajeinicio= new Label("REGISTRATE");
	private TextField username = new TextField("USUARIO");
	private TextField mail = new TextField("CORREO ELECTRÓNICO");
	private TextField cuit_cuil = new TextField("CUIT O CUIL");
	private PasswordField contraseña = new PasswordField("CONTRASEÑA");
	
	private Button aceptar=new Button("ACEPTAR");
	private BeanFieldGroup<Usuario> formFieldBindings;
	private ServicioUsuario servicioUsuario=new ServicioUsuario();
	
	private Usuario usuario=new Usuario();
	private Window subWindow = new Window("Error en registro");
	private Window subWindow2 = new Window("Error en registro");
	
	private Label errorMail=new Label("El Mail ingresado es incorrecto");
	
	private Label errorPassword=new Label("El Password ingresado es incorrecto. Recuerde que debe tener entre 4 y 12 caracteres. Para su mayor seguridad incluya números y mayusculas en él. ");
	private VerticalLayout verLay2=new VerticalLayout();
	private VerticalLayout verLay3=new VerticalLayout();
	
	public Registro(){
		formFieldBindings =BeanFieldGroup.bindFieldsBuffered(usuario, this);
		
		configurarComponentes();
		construirLayout();
		
		
		
		aceptar.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					formFieldBindings.commit();
				} catch (CommitException e) {
					e.printStackTrace();
				}
				
				if(servicioUsuario.VerificarMail(usuario) && servicioUsuario.VerificarPassword(usuario)){
					servicioUsuario.registrar(usuario);
					getUI().getNavigator().navigateTo(Menu.NAME);}
				else if(!servicioUsuario.VerificarMail(usuario)){
					getUI().addWindow(subWindow);
				}
				else if(!servicioUsuario.VerificarPassword(usuario)){
					
					getUI().addWindow(subWindow2);
				}
				
				
					}
		});
		
		
	}
	
	private void configurarComponentes() {
		
		username.setValue("");
		mail.setValue("");
		contraseña.setValue("");
		cuit_cuil.setValue("");
		subWindow.setContent(verLay2);
		subWindow2.setContent(verLay3);
	
	}

	private void construirLayout(){
		
		
		
		form.addComponent(mensajeinicio);
		form.addComponent(username);
		form.addComponent(mail);
		form.addComponent(contraseña);
		form.addComponent(cuit_cuil);
		verLay2.addComponent(errorMail);
		verLay3.addComponent(errorPassword);
		
		addComponent(form);
	
		addComponent(aceptar);
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
package com.example.redsocialcartelesled.presentacion;

import com.example.redsocialcartelesled.domainmodel.Usuario;
import com.example.redsocialcartelesled.services.ServicioPublicadorUsuario;
import com.example.redsocialcartelesled.services.ServicioUsuario;
import com.gargoylesoftware.htmlunit.javascript.host.KeyboardEvent;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;


public class Logueo extends FormLayout implements View {

	protected static final String NAME = "logueo";
	private FormLayout form = new FormLayout();
	private Label mensajeinicio= new Label("INICIO DE SESION");
	private TextField username = new TextField("USUARIO");
	private PasswordField contraseña = new PasswordField("CONTRASEÑA");
	private HorizontalLayout horLay=new HorizontalLayout();
	private Label mensajeregistro= new Label("AÚN NO TIENES CUENTA??");
	private Button registro=new Button("REGISTRATE!!");
	private Button iniciarsesion=new Button("INICIAR SESION");
	private ServicioUsuario servicioUsuario=new ServicioUsuario();
	private Usuario usuario=new Usuario();
	private BeanFieldGroup<Usuario> formFieldBindings;
	private Window subWindow = new Window("Usuario inexistente");
	private VerticalLayout verLay2=new VerticalLayout();
	private Label userInex=new Label("El Usuario no existe o el password es erroneo");
	public Logueo(){
		
		formFieldBindings =BeanFieldGroup.bindFieldsBuffered(usuario, this);
		
		configurarComponentes();
		
		construirLayout();
		
		
		registro.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(Registro.NAME);
				
			}
		});
	
		iniciarsesion.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					formFieldBindings.commit();
					
				} catch (CommitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				if(servicioUsuario.login(usuario)){
					getUI().getNavigator().navigateTo(Menu.NAME);
				}
				else{
					getUI().addWindow(subWindow);
				}
				
			}
		});
		
	
	}
	private void configurarComponentes(){
		subWindow.setContent(verLay2);
		
		username.setValue("");
		contraseña.setValue("");
		
	}
	private void construirLayout(){
		
		form.addComponent(mensajeinicio);
		form.addComponent(username);
		form.addComponent(contraseña);
		
		horLay.addComponent(mensajeregistro);
		horLay.addComponent(registro);
		horLay.setSpacing(true);
		
		addComponent(form);
		
		addComponent(iniciarsesion);
		
		addComponent(horLay);
		
		
		verLay2.addComponent(userInex);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}

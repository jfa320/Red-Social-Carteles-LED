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
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;


public class Inicio extends FormLayout implements View {

	protected static final String NAME = "";
	private FormLayout form = new FormLayout();
	private Label mensajeinicio= new Label("BIENVENIDOS A OPLED, LA PRIMERA RED SOCIAL"
			+ "QUE PERMITE COMPARTIR SUS OPINIONES EN DIRECTO");
	private HorizontalLayout horLay=new HorizontalLayout();
	private Button registro=new Button("REGISTRARSE");
	private Button logueo=new Button("INICIAR SESION");
	private ServicioUsuario servicioUsuario=new ServicioUsuario();
	private Usuario usuario=new Usuario();
	private BeanFieldGroup<Usuario> formFieldBindings;
	
	public Inicio(){
		
		
		
		construirLayout();

	
		
		
		registro.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(Registro.NAME); //ACA SE DEBE CAMBIAR POR EL NOMBRE DE LA CLASE QUE MUESTRA LOS POST
				
			}
		});
		
		logueo.addClickListener(new Button.ClickListener() {
		
			@Override
			public void buttonClick(ClickEvent event) {
				
				
		
					getUI().getNavigator().navigateTo(Logueo.NAME);
				
			}
		
		
	
		});}
	
	private void construirLayout(){
		
		form.addComponent(mensajeinicio);
		
		horLay.addComponent(registro);
		horLay.setSpacing(true);
		horLay.addComponent(logueo);
		addComponent(form);
		
		
		addComponent(horLay);
		

}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
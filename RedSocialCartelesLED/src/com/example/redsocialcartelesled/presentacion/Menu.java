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


public class Menu extends FormLayout implements View {

	protected static final String NAME = "menu";
	private FormLayout form = new FormLayout();
	private Label mensajeinicio= new Label("MENU PRINCIPAL");
	private HorizontalLayout horLay=new HorizontalLayout();
	private Button inicio=new Button("INICIO");	
	private Button publicar=new Button("PUBLICAR");
	private Button calificar=new Button("CALIFICAR POST");
	private ServicioUsuario servicioUsuario=new ServicioUsuario();
	private Usuario usuario=new Usuario();
	private BeanFieldGroup<Usuario> formFieldBindings;
	public Menu(){
		
	
		
		construirLayout();

		
		
		
		inicio.addClickListener(new Button.ClickListener() {
		
			@Override
			public void buttonClick(ClickEvent event) {
				
				getUI().getNavigator().navigateTo(PostMasPopulares.NAME); 
				
			}
		});
		
		publicar.addClickListener(new Button.ClickListener() {
		
			@Override
			public void buttonClick(ClickEvent event) {
				
				
					getUI().getNavigator().navigateTo(CreacionPost.NAME);
				}
				
			
		});
		
		calificar.addClickListener(new Button.ClickListener() {
			
			
			public void buttonClick(ClickEvent event) {
				
				
					getUI().getNavigator().navigateTo(CalificacionPost.NAME);
				}
				
		});
		
		
	
	}
	
	private void construirLayout(){
		
		
		form.addComponent(mensajeinicio);
		
	
		
		horLay.addComponent(inicio);
		horLay.setSpacing(true);
		horLay.addComponent(publicar);
		horLay.setSpacing(true);
		horLay.addComponent(calificar);
		
		addComponent(form);
		
		addComponent(horLay);
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}

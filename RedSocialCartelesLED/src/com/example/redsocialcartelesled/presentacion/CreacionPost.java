package com.example.redsocialcartelesled.presentacion;

import com.example.redsocialcartelesled.domainmodel.Post;
import com.example.redsocialcartelesled.services.ServicioPublicadorUsuario;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;


public class CreacionPost extends FormLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "Post";
	
	private Button subirImg=new Button("Subir Imagen");
	
	private Button publicar=new Button("Publicar");
	private Label mensaje=new Label("Expresa tus pensamientos!");
	private TextField cuerpo=new TextField();
	
	private ServicioPublicadorUsuario servicioPublicadorUsuario=new ServicioPublicadorUsuario();
	
	private Post post=new Post();
	private BeanFieldGroup<Post> formFieldBindings;
	public CreacionPost(){

		formFieldBindings =BeanFieldGroup.bindFieldsBuffered(post, this);
		configurarComponentes();
		construirLayout();
		
		
		publicar.addClickListener(new Button.ClickListener() {
		
			@Override
			public void buttonClick(ClickEvent event) {	
				
			try {
				formFieldBindings.commit();
			} catch (CommitException e) {
				e.printStackTrace();
			}
			servicioPublicadorUsuario.publicarPost(post);
			}
		});
		
		
		
		
	}
	
	private void configurarComponentes(){
		mensaje.setSizeFull();
		cuerpo.setMaxLength(300); //limitar el maximo de caracteres admitidos
		cuerpo.setHeight(125, Unit.PIXELS);
		cuerpo.setWidth(300, Unit.PIXELS);
		cuerpo.setValue("");
	}
		
	private void construirLayout(){
		
		
		HorizontalLayout horLay=new HorizontalLayout();
		horLay.addComponent(subirImg);
		horLay.addComponent(publicar);
		horLay.setSpacing(true);
		
		
		
		setSpacing(true);
		addComponent(mensaje);
		addComponent(cuerpo);
		addComponent(horLay);
	
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}

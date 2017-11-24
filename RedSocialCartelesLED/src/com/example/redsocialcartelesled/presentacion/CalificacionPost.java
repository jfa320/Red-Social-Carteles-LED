package com.example.redsocialcartelesled.presentacion;



import com.example.redsocialcartelesled.domainmodel.Post;
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
import com.vaadin.ui.Button.ClickEvent;

public class CalificacionPost extends FormLayout implements View {

	
	protected static final String NAME = "Calificacion";
	private ServicioPublicadorUsuario servicioPublicadorUsuario=new ServicioPublicadorUsuario();
	private TextField area=new TextField(); 
	private Label label=new Label("Califica el post!");
	private Button aceptar=new Button("Aceptar");
	private Post post=servicioPublicadorUsuario.levantarUltimoPost();
	private Label escritoPor=new Label("escrito por " + post.getPublicador().getUsername());
	private OptionGroup group = new OptionGroup("Calificacion");
	
	public CalificacionPost(){

		this.configurarComponentes();
		this.construirLayout();
		
		aceptar.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				servicioPublicadorUsuario.recibirCalificacion(post, Integer.parseInt(group.getValue().toString()));
				getUI().getNavigator().navigateTo(Menu.NAME);
			}
		});
		
	}
	
	private void configurarComponentes(){
		
		area.setValue(post.getCuerpo());
		area.setReadOnly(true);
	
		
		
		group.addItems("1", "2", "3","4","5");
		group.addStyleName("horizontal");
	}
	
	private void construirLayout(){
		VerticalLayout verLay=new VerticalLayout();
		verLay.setSpacing(true);
		verLay.addComponent(label);
		verLay.addComponent(area);
		verLay.addComponent(escritoPor);
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

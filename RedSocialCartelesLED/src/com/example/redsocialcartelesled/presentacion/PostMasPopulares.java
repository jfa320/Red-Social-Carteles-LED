package com.example.redsocialcartelesled.presentacion;

import java.util.List;

import com.example.redsocialcartelesled.domainmodel.Post;
import com.example.redsocialcartelesled.services.ServicioPublicadorUsuario;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class PostMasPopulares extends FormLayout implements View{
	private VerticalLayout verLay=new VerticalLayout();
	private ServicioPublicadorUsuario servicio=new ServicioPublicadorUsuario();
	
	
	protected static final String NAME = "popular";
	private List<Post> posts=servicio.levantarCincoPost();
	private Button volverMenu=new Button ("MENU");
	private Panel panel1;
	private Panel panel2;
	private Panel panel3;
	private Panel panel4;
	private Panel panel5;

	
	private Button actualizar=new Button("Actualizar Posts");
	
	public PostMasPopulares(){
		

	configurarComponentes();
	construirLayout();

	
	;
	actualizar.addClickListener(new Button.ClickListener() {
		
		@Override
		public void buttonClick(ClickEvent event) {
			
			Page.getCurrent().reload();
			
		}
	});
	
	}
	public void configurarComponentes(){
		panel1=new Panel("Post publicado por "+posts.get(0).getPublicador().getUsername());
		panel2=new Panel("Post publicado por "+posts.get(1).getPublicador().getUsername());
		panel3=new Panel("Post publicado por "+posts.get(2).getPublicador().getUsername());
		panel4=new Panel("Post publicado por "+posts.get(3).getPublicador().getUsername());
		panel5=new Panel("Post publicado por "+posts.get(4).getPublicador().getUsername());
		
		
		panel1.setContent(new Label("Contenido del post: "+posts.get(0).getCuerpo()));
		panel2.setContent(new Label("Contenido del post: "+posts.get(1).getCuerpo()));
		panel3.setContent(new Label("Contenido del post: "+posts.get(2).getCuerpo()));
		panel4.setContent(new Label("Contenido del post: "+posts.get(3).getCuerpo()));
		panel5.setContent(new Label("Contenido del post: "+posts.get(4).getCuerpo()));

		
		volverMenu.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(Menu.NAME);
				
			}
		});
		
	}
		
	
	public void construirLayout(){
		verLay.addComponent(panel1);
		verLay.addComponent(panel2);
		verLay.addComponent(panel3);
		verLay.addComponent(panel4);
		verLay.addComponent(panel5);
		this.addComponent(verLay);
		this.addComponent(actualizar);
		addComponent(volverMenu);
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}

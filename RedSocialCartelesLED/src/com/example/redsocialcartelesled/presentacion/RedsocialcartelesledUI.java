package com.example.redsocialcartelesled.presentacion;

import javax.servlet.annotation.WebServlet;

import com.example.redsocialcartelesled.services.ServicioPublicadorUsuario;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;


@SuppressWarnings("serial")
@Theme("redsocialcartelesled")
public class RedsocialcartelesledUI extends UI {
	private Navigator navegador;
	
	
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = RedsocialcartelesledUI.class, widgetset = "com.example.redsocialcartelesled.presentacion.widgetset.RedsocialcartelesledWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		configurarComponentes();
		
	}
	
	private void configurarComponentes(){
		navegador=new Navigator(this,this);
		navegador.addView(Logueo.NAME, new Logueo());
		navegador.addView(CreacionPost.NAME, new CreacionPost());
//		navegador.addView(CalificacionPost.NAME, new CalificacionPost());
//		navegador.addView(Registro.NAME, new Registro());
		
	}

}
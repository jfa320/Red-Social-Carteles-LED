package com.example.redsocialcartelesled.presentacion;

import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;


@SuppressWarnings("serial")
@Theme("redsocialcartelesled")
public class RedsocialcartelesledUI extends UI {
	Navigator navegador;
	
	
	
	
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = RedsocialcartelesledUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		configurarComponentes();
		
	}
	
	private void configurarComponentes(){
		navegador=new Navigator(this,this);
		navegador.addView(creacionPost.NAME, new creacionPost());
	}

}
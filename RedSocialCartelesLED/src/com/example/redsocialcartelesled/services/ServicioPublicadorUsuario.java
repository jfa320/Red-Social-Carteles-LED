package com.example.redsocialcartelesled.services;

import java.util.Date;

import com.example.redsocialcartelesled.daosImpl.HibernateDAOPublicadorUsuario;
import com.example.redsocialcartelesled.daosgenericos.DAOPublicadorUsuario;
import com.example.redsocialcartelesled.domainmodel.Post;
import com.example.redsocialcartelesled.domainmodel.Publicacion;
import com.example.redsocialcartelesled.domainmodel.Usuario;

public class ServicioPublicadorUsuario {
	private DAOPublicadorUsuario publicadorDAO=new HibernateDAOPublicadorUsuario();
	private Date fechaHoraActual;
	
	
	public void publicarPost(Post post){
		

		fechaHoraActual=new Date();

		post.setFechaHoraCreacion(fechaHoraActual);
		
		Usuario publicador=new Usuario();//hardcodeado,modificar para 2da entrega
		
		post.setPublicador(publicador);
		
		publicadorDAO.persistir((Publicacion)post);
	}
	
	
	
}

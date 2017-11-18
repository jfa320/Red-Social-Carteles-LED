package com.example.redsocialcartelesled.services;

import java.util.Date;

import com.example.redsocialcartelesled.daosImpl.HibernateDAOPublicadorUsuario;
import com.example.redsocialcartelesled.daosImpl.HibernateDAOServicioUsuario;
import com.example.redsocialcartelesled.daosgenericos.DAOPublicadorUsuario;
import com.example.redsocialcartelesled.daosgenericos.DAOServicioUsuario;
import com.example.redsocialcartelesled.domainmodel.Post;
import com.example.redsocialcartelesled.domainmodel.Publicacion;
import com.example.redsocialcartelesled.domainmodel.Usuario;

public class ServicioPublicadorUsuario {
	private DAOPublicadorUsuario publicadorDAO;
	private DAOServicioUsuario usuarioDAO;
	private Date fechaHoraActual;
	
	
	public void publicarPost(Post post){
		

		fechaHoraActual=new Date();

		post.setFechaHoraCreacion(fechaHoraActual);
		usuarioDAO=new HibernateDAOServicioUsuario();
		Usuario publicador=usuarioDAO.buscarPorId(Usuario.class, 3L);//hardcodeado,modificar para 2da entrega
		
//		usuarioDAO.cerrar();
		System.out.println(publicador.getUsername());
		
		publicadorDAO=new HibernateDAOPublicadorUsuario();
		post.setPublicador(publicador);
		
		publicadorDAO.persistir((Publicacion)post);
//		publicadorDAO.cerrar();
//		usuarioDAO.cerrar();
	}
	
	
	
}

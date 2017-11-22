package com.example.redsocialcartelesled.services;

import java.util.ArrayList;
import java.util.Date;

import com.example.redsocialcartelesled.daosImpl.HibernateDAOPublicadorUsuario;
import com.example.redsocialcartelesled.daosImpl.HibernateDAOServicioUsuario;
import com.example.redsocialcartelesled.daosgenericos.DAOPublicadorUsuario;
import com.example.redsocialcartelesled.daosgenericos.DAOServicioUsuario;
import com.example.redsocialcartelesled.domainmodel.Calificacion;
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
	
	public Post levantarUltimoPost(){
		Post post=new Post();
		Calificacion c=new Calificacion();
		c.setNota(3);
		c.setPostCorrespondiente(post);
		ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
		calificaciones.add(c);
		post.setCalificaciones(calificaciones);
		post.setCuerpo("Hola,que haces?");
		Date fechaYHoraCreacion=new Date();
		post.setFechaHoraCreacion(fechaYHoraCreacion);
		post.setImg(null);
		post.setPopularidad(3);
		Usuario publicador=new Usuario();
		publicador.setUsername("Carlos");
		post.setPublicador(publicador);
		
//		publicadorDAO.buscarPorId(post, 1L);
		return post;
	}
	
	
}

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
		Usuario publicador=usuarioDAO.buscarPorId(Usuario.class, 1L);//hardcodeado,modificar para 2da entrega
		
		publicadorDAO=new HibernateDAOPublicadorUsuario();
		post.setPublicador(publicador);
		
		publicadorDAO.persistir((Publicacion)post);

	}
	
	public Post levantarUltimoPost(){

		publicadorDAO=new HibernateDAOPublicadorUsuario();
		Post post=(Post) publicadorDAO.buscarPorId(Publicacion.class, 2L); //harcodeado ver si es posible automatizar levantar ultimo post
		return post;
	}
	public void recibirCalificacion(Post post,int calificacion){
		
		Calificacion nota=new Calificacion();
		nota.setNota(calificacion);
		nota.setPostCorrespondiente(post);
		
		
		
		post.getCalificaciones().add(nota);
		actualizarPopularidad(post);
		
		publicadorDAO.actualizar(post);
	}
	
	private void actualizarPopularidad(Post post){
		int popularidad=0;
		
		popularidad+=post.getCalificaciones().get(post.getCalificaciones().size()-1).getNota();
		
		popularidad+=post.getPopularidad();
		post.setPopularidad(popularidad);
		
	}
}

package com.example.redsocialcartelesled.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		Usuario publicador=usuarioDAO.buscarPorId(Usuario.class, 1L);//hardcodeado el usuario con ID 1 para crear posts
		
		publicadorDAO=new HibernateDAOPublicadorUsuario();
		post.setPublicador(publicador);
		
		publicadorDAO.persistir((Publicacion)post);
		}
	
	public Post levantarUltimoPost(){ //FUNCIONALIDAD EXTRA

		publicadorDAO=new HibernateDAOPublicadorUsuario();
		Publicacion post=new Publicacion();
		List <Publicacion> lista=publicadorDAO.recuperarTodo(post);
		post=lista.get(lista.size()-1);
		return (Post) post;
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

	public List<Post> levantarCincoPost() {
		publicadorDAO=new HibernateDAOPublicadorUsuario();
		Publicacion pub=new Publicacion();
		List<Publicacion> posts=publicadorDAO.recuperarTodo(pub);
		int contador=0;
		List<Post> result=new ArrayList<Post>();
		
		
		while(contador<5){
			int numero = (int) (Math.random() * posts.size());
			if(!result.contains(posts.get(numero))){
				result.add((Post) posts.get(numero));
				contador++;
			}
		}
		
		
		
		return result;
	}
}

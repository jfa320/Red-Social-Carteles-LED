package com.example.redsocialcartelesled.services;

import java.util.Date;

import com.example.redsocialcartelesled.daos.DAOPublicadorUsuario;
import com.example.redsocialcartelesled.daos.HibernateDAOPublicadorUsuario;
import com.example.redsocialcartelesled.domainmodel.Post;
import com.example.redsocialcartelesled.domainmodel.Usuario;

public class ServicioPublicadorUsuario {
	private DAOPublicadorUsuario publicadorDAO=new HibernateDAOPublicadorUsuario();
	private Date fechaHoraActual;
	
	
	public void publicarPost(String campo){
		
		Post post=new Post();
		fechaHoraActual=new Date();
		post.setCuerpo(campo);
		post.setImg(null);
		post.setPopularidad(0);
		post.setFechaHoraCreacion(fechaHoraActual);
		
		Usuario publicador=new Usuario();//hardcodeado,modificar para 2da entrega
		
		post.setPublicador(publicador);
		
		publicadorDAO.persistirPost(post);
	}
	
	
	
}

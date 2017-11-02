package com.example.redsocialcartelesluminosos.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.example.redsocialcartelesluminosos.domainmodel.Publicacion;

import com.example.redsocialcartelesluminosos.domainmodel.Post;

public class HibernateDAOPublicadorUsuario implements DAOPublicadorUsuario {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	
	@Override
	public void persistirPost(Post post) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(post);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

}

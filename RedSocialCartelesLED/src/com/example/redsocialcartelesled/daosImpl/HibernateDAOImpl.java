package com.example.redsocialcartelesled.daosImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.redsocialcartelesled.daosgenericos.DAO;

public class HibernateDAOImpl<T> implements DAO<T> {
	private EntityManagerFactory entityManagerFactory;
	
	public HibernateDAOImpl(){
		entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	}
	
	@Override
	public T persistir(T t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return t;
	}

	@Override
	public void eliminar(T t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.remove(entityManager.merge(t)); //merge para que ande
		
		entityManager.getTransaction().commit();;
		entityManager.close();
		
	}

	@Override
	public T buscarPorId(final Class<T> type,Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		T t=entityManager.find(type, id); 
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return t;
	}

}

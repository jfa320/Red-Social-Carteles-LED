package com.example.redsocialcartelesled.daosImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.redsocialcartelesled.daosgenericos.DAO;

public class HibernateDAOImpl<T> implements DAO<T> {
	private EntityManagerFactory entityManagerFactory;
	private T clase;
	
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
		
		entityManager.remove(entityManager.merge(t)); 
		
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

	@Override
	public void cerrar() {
		entityManagerFactory.close();
		
	}
	@SuppressWarnings(value={"unchecked"})
	@Override
	public List<T> recuperarTodo(T tipo) {

		this.clase=tipo;
		List<T> result = new ArrayList<T>();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		
		result = entityManager.createQuery( "from "+ clase.getClass().getSimpleName()).getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}

	@Override
	public void actualizar(T entidad) { 
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.merge(entidad);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

}

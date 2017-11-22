package com.example.redsocialcartelesled.daosgenericos;

import java.util.List;

public interface DAO<T> {
	public T persistir(T t);
	public void eliminar(T t);
	public T buscarPorId(final Class<T> type,Long id);
	public void cerrar();
	public List<T> recuperarTodo(T tipo);
	public void actualizar(T entidad);
	}

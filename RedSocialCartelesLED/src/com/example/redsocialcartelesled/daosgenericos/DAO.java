package com.example.redsocialcartelesled.daosgenericos;

public interface DAO<T> {
	public T persistir(T t);
	public void eliminar(T t);
	public T buscarPorId(final Class<T> type,Long id);
	public void cerrar();
}

package co.com.apuestas.application;

import java.util.List;

public interface IGenericController<T, U> {

	public void create(T entity);

	public void edit(T entity);

	public void remove(T entity);

	public T find(U id);

	public List<T> findAll();

}

package co.com.apuestas.services;

import java.util.List;

public interface IGenericService<T,U> {
	
	public void create(T entity);
	public void edit(T entity);
	public void remove(U id);
	public T find(U id);
	public List<T> findAll();

}

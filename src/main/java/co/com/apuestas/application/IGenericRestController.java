package co.com.apuestas.application;

import java.util.List;

public interface IGenericRestController<T, U> {

	public abstract List<T> findAll();

	public abstract T find(U id);

	public abstract void save(T entity);

	public abstract void create(T entity);

	public abstract void delete(U id);

}

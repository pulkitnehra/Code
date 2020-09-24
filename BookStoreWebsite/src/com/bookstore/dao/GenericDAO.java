package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Users;

public interface GenericDAO<E> {
	
	public E create(E entity);
	
	public E update(E entity);
	
	public E get(Object id);
	
	public void delete(Object id);

	public List<E> listAll();
	
	public long count();
	
}

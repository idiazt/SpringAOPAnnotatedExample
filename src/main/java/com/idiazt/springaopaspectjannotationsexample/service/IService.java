package com.idiazt.springaopaspectjannotationsexample.service;

import java.util.Collection;

import com.idiazt.springaopaspectjannotationsexample.entities.BaseEntity;

public interface IService<E extends BaseEntity> {
	public E persist(E entity);

	public Collection<E> list();

	public E findById(Long id);

	public boolean delete(Long id);
}

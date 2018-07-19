package com.jazzinjars.spring.bootjersey.service;

import com.jazzinjars.spring.bootjersey.rest.model.User;

import java.util.List;

public interface CRUDService<T> {

	T save(T entity);

	T findById(Integer identifier);

	List<T> searchByCompanyName(String companyName);

	void deleteById(Integer identifier);
}

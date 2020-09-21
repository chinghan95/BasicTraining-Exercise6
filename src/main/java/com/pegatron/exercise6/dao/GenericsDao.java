package com.pegatron.exercise6.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pegatron.exercise6.model.BaseModel;
import com.pegatron.exercise6.model.Book;
import com.pegatron.exercise6.model.Bookstore;

//@Repository
public interface GenericsDao {

	public <T extends BaseModel> List<T> findAll(Class<T> persistClass);
	
	public <T extends BaseModel> void saveOrUpdate(T t);

	public <T extends BaseModel> void delete(T t);

	public <T extends BaseModel> T load(Serializable pk, Class<T> entityClass);

//	public <T extends Book> List<T> findAllByQuery(String query);

}

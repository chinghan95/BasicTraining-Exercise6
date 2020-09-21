package com.pegatron.exercise6.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pegatron.exercise6.dao.GenericsDao;
import com.pegatron.exercise6.model.BaseModel;
import com.pegatron.exercise6.model.Book;
import com.pegatron.exercise6.model.Bookstore;
import com.pegatron.exercise6.service.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private GenericsDao genericsDao;

	@Override
	@Transactional
	public <T extends BaseModel> List<T> findAllBookstores(Class<T> persistClass) {
		return genericsDao.findAll(persistClass);
	}

	@Override
	@Transactional
	public <T extends BaseModel> void saveOrUpdate(T t) {
		genericsDao.saveOrUpdate(t);
	}

	@Override
	@Transactional
	public <T extends BaseModel> void delete(T t) {
		genericsDao.delete(t);
	}

	@Override
	@Transactional
	public Bookstore getBookstore(Serializable pk) {
		Bookstore bookstore = genericsDao.load(pk, Bookstore.class);
		Hibernate.initialize(bookstore.getBooks());
		return bookstore;
	}

	@Override
	@Transactional
	public <T extends BaseModel> T load(Serializable pk, Class<T> entityClass) {
		T t = genericsDao.load(pk, entityClass);
		return t;
	}

//	@Override
//	@Transactional
//	public List<Bookstore> findAllBookstores() {
//		return genericsDao.findAll(Bookstore.class);
//	}

//	@Override
//	@Transactional
//	public void saveOrUpdateBookstore(Bookstore bookstore) {
//		genericsDao.saveOrUpdate(bookstore);
//	}

//	@Override
//	@Transactional
//	public void deleteBookstore(Bookstore bookstore) {
//		genericsDao.delete(bookstore);
//	}

//	@Override
//	@Transactional
//	public List<Book> findAllBooks(Serializable pk) {
//		String command = "FROM Book WHERE Store_Id = " + pk;
//		return genericsDao.findAllByQuery(command);
//	}

//	@Override
//	@Transactional
//	public void saveOrUpdateBook(Book book) {
//		genericsDao.saveOrUpdate(book);
//	}

//	@Override
//	@Transactional
//	public void deleteBook(Book book) {
//		genericsDao.delete(book);
//	}

//	@Override
//	@Transactional
//	public Book getBook(Serializable pk) {
//		Book Book = genericsDao.load(pk, Book.class);
//		return Book;
//	}

}

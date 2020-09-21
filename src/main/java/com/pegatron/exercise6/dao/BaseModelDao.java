/**
 * The @Repository annotation is a marker for any class 
 * that fulfills the role or stereotype of a repository 
 * (also known as Data Access Object or DAO).
 */

package com.pegatron.exercise6.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pegatron.exercise6.model.BaseModel;
import com.pegatron.exercise6.model.Book;
import com.pegatron.exercise6.model.Bookstore;

@Repository
public class BaseModelDao implements GenericsDao {

	@Autowired
	private SessionFactory sessionFactory;

//	@Autowired
//	public void setSessionFactory(EntityManagerFactory factory) {
//		if(factory.unwrap(SessionFactory.class) == null){
//			throw new NullPointerException("factory is not a hibernate factory");
//		}
//		this.sessionFactory = factory.unwrap(SessionFactory.class);
//	}

	protected final Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public <T extends BaseModel> List<T> findAll(Class<T> entityClass) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		Root<T> root = query.from(entityClass);
		query.select(root);
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public <T extends BaseModel> void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}

	@Override
	public <T extends BaseModel> void delete(T t) {
		getSession().delete(t);
	}

	@Override
	public <T extends BaseModel> T load(Serializable pk, Class<T> entityClass) {
		return getSession().byId(entityClass).load(pk);
	}

//	@SuppressWarnings({ "unchecked" })
//	@Override
//	public <T extends Book> List<T> findAllByQuery(String query) {
//		return getSession().createQuery(query).getResultList();
//	}

}

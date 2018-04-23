package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

//another annotation...
@Transactional
@Repository("categoryDAO") // will create instance of CategoryDAOImpl and the name will categoryDAO
public class CategoryDAOImpl implements CategoryDAO {

	// first - inject hibernate session.
	// @Autowire

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private Category category;

	//
	public boolean save(Category category) {
		// store in the database.
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Category get(String id) {
		// it will fetch the record based on id and store in Category class
		return sessionFactory.getCurrentSession().get(Category.class, id);

	}

	public boolean delete(String id) {
		try {
			category = get(id);
			if (category == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(category);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List<Category> list() {
	//return	sessionFactory.getCurrentSession().createQuery("from Category").list();
		return (List<Category>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}



}

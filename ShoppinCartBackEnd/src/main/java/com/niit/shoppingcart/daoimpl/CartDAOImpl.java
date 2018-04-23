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

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.Cart;

//another annotation...
@Transactional
@Repository("cartDAO") // will create instance of CartDAOImpl and the name will cartDAO
public class CartDAOImpl implements CartDAO {

	// first - inject hibernate session.
	// @Autowire

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private Cart cart;

	//
	public boolean save(Cart cart) {
		// store in the database.
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Cart get(String id) {
		// it will fetch the record based on id and store in Cart class
		return sessionFactory.getCurrentSession().get(Cart.class, id);

	}

	public boolean delete(String id) {
		try {
			cart = get(id);
			if (cart == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(cart);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	
	public List<Cart> list(String emailID) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.add(Restrictions.eqOrIsNull("emailID", emailID)).list();
	}

	public boolean update(String emailID) {
		// TODO Auto-generated method stub
		return false;
	}



}

package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

//another annotation...
@Transactional
@Repository("supplierDAO") // will create instance of SupplierDAOImpl and the name will supplierDAO
public class SupplierDAOImpl implements SupplierDAO {

	// first - inject hibernate session.
	// @Autowire

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private Supplier supplier;

	//
	public boolean save(Supplier supplier) {
		// store in the database.
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Supplier get(String emailID) {
		// it will fetch the record based on emailID and store in Supplier class
		return sessionFactory.getCurrentSession().get(Supplier.class, emailID);

	}

	public boolean delete(String emailID) {
		try {
			supplier = get(emailID);
			if (supplier == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(supplier);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List<Supplier> list() {
	return	sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	

}
package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;
@Service

@Transactional
@Repository("userDAO") // will create instance of UserDAOImpl
public class UserDAOImpl implements UserDAO {
	
	private static final org.jboss.logging.Logger log = LoggerFactory.logger(UserDAOImpl.class);
	/*private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);*/
	// first inject hibernate session
	// @Autowired

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private User user;

	public boolean save(User user) {
		// store in the DB
		try {
			user.setRole('c');
			user.setRegisteredDate(new Date(System.currentTimeMillis()) + "");
			sessionFactory.getCurrentSession().save(user);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		log.debug("Starting of the update method");
		try {
			sessionFactory.getCurrentSession().update(user);
			log.debug("Ending of the update method");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in delete method" + e.getMessage());
			return false;
		}

	}

	public User get(String emailID) {
		
		log.debug("Starting of the get method");
		// fetch record based on email id and store in the class
		
		 return sessionFactory.getCurrentSession().get(User.class, emailID);
		

	}

	public boolean delete(String emailID) {
		log.debug("Starting of the delete method");
		try {
			user = get(emailID);
			if (user == null) {
				return false;
			}
				sessionFactory.getCurrentSession().delete(user);
				log.debug("Ending of the delete method");
			    return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error("error occured in delete method" + e.getMessage());
			return false;
		}
	}

	public List<User> list() {
		log.debug("Starting of the list method");
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User validate(String emailID, String password) {
		log.debug("Starting of the validate method");
		log.info(" user " + emailID + "trying to login");
	User user = (User)sessionFactory.getCurrentSession().
		createCriteria(User.class).
		add(Restrictions.eq("emailID",emailID )).
		add(Restrictions.eq("pwd",password)).
		uniqueResult();
	return user;
	}

}

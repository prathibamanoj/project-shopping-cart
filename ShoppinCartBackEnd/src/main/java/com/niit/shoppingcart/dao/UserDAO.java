package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.shoppingcart.domain.User;

@Service
public interface UserDAO {
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public User get(String emailID);
	
	public boolean delete(String emailID);
	
	public List<User> list();
	
	public User validate(String emailID,String password);

}

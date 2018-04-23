package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.shoppingcart.domain.Category;

@Service
public interface CategoryDAO {
	
	public boolean save(Category category);
	
	public boolean update(Category category);
	
	public Category get(String Id);
	
	public boolean delete(String Id);
	
	public List<Category> list();
	
	/*public Category validate(String emailID,String password);*/

}

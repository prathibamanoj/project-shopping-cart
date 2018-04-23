package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Cart;


//DAO -> Data Access Object
public interface CartDAO {
	
	//declare the methods.
	
	//create new cart
	
	public boolean save(Cart cart);
	
	
	//update the existing cart
	
	public boolean update(Cart cart);
	
	//related to order 
	
	public boolean update(String emailID);
	
	
	//get the cart details
	
	public   Cart     get(String id);
	
	
	//delete the cart
	
	public   boolean    delete(String id);
	
	//to get all the carts add by a particular user
	public List<Cart>   list(String emailID);
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

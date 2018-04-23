package com.niit.shoppincartbackend;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.Cart;

public class CartDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CartDAO cartDAO;
	
	@Autowired
	private static Cart cart;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		//scan the complete package and check for annoations like
		//@Component, @Controller, @Repository, @Service
		context.scan("com.niit"); 
		//clear the context(bean factory, and recreate all the
		//instances of the classes which are there in com.niit
		//with proper annotations.
		context.refresh();
		//ask the context to get instance of CartDAO
		cartDAO = (CartDAO)context.getBean("cartDAO");
		cart = (Cart)context.getBean("cart");
	}
	@Test
	public void saveCartTestCase()
	{
		cart = new Cart();
		cart.setEmailID("syed@gmail.com");
		cart.setProductName("Women");
		
		
	  boolean status = 	cartDAO.save(cart);
	  
	  assertEquals("save cart test case", true, status);
	}
	
	
	@Test
	public void updateCartTestCase()
	{
		cart.setEmailID("Mob-001");
		/*cart.setName("Mobile");
		cart.setDescription("This is new mobile cart");
		boolean status = cartDAO.update(cart);
		assertEquals("update test case", true,status );*/
	}
	
	/*@Test
	public void getCartSuccessTestCase()
	{
		
	cart= cartDAO.get("jaskaran1@gmail.com");
	
	assertNotNull("get cart test case", cart);
	}
	
	@Test
	public void getCartFailureTestCase()
	{
		
	cart= cartDAO.get("jaya@gmail.com");
	
	assertNull("get cart test case", cart);
	}*/
	
	@Test
	public void deleteCartSuccessTestCase()
	{
	boolean status =	cartDAO.delete("jaskaran1@gmail.com");
	assertEquals("delete cart succss test case" , true, status);
	
	}
	
	@Test
	public void deleteCartFailureTestCase()
	{
	boolean status =	cartDAO.delete("arpith@gmail.com");
	assertEquals("delete cart failure test case" , false, status);
	
	}
	
	
	@Test
	public void getAllCartsTestCase()
	{
	List<Cart>	carts = cartDAO.list("emailID");
	
	assertEquals("get all cart " , 5, carts.size() );
	
	}
}
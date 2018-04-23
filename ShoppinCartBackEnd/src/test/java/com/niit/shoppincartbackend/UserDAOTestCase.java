package com.niit.shoppincartbackend;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

public class UserDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static UserDAO userDAO;
	
	@Autowired
	private static User user;
	 
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		//scan the complete package and check for annotations like
		//@component,@controller,@repository,@service
		context.scan("com.niit");
		//clear the context(bean factory and recreate all the
		//instances of the classes which are there in com.niit
		//with proper annotations
		context.refresh();
		//ask the context to get instance of UserDAO		
		userDAO = (UserDAO) context.getBean("userDAO");
		//ask the context to get instance of User
		user = (User) context.getBean("user");
	}
	
	@Test
	public void saveUserTestCase()
	{
		user = new User();
		user.setEmailID("sha96@gmail.com");
		user.setMobile("9789988976");
		user.setName("A.syed_shahabuddin");
		user.setPwd("syed1996");		
		
		boolean status = userDAO.save(user);		
		assertEquals("save user test case",true,status);
	}
	
	@Test
	public void updateUserTestCase()
	{
		user.setEmailID("syed@gmail.com");
		user.setMobile("9789988976");
		user.setName("A.syed_shahabuddin");
		user.setPwd("syed1996");		
		
		boolean status=userDAO.update(user);
		assertEquals("update test case",true,status );
	}
	
	@Test
	public void getUserSuccessTestCase()
	{
		user = userDAO.get("syed96@gmail.com");
		assertNotNull("get user test case", user);
	}
	
	@Test
	public void getUserFailureTestCase()
	{
		user = userDAO.get("syed@gmail.com");
		assertNull("get user test case", user);
	}
	
	@Test
	public void deleteUserSuccessTestCase()
	{
		boolean status = userDAO.delete("syed16@gmail.com");
		assertEquals("delete user success test case",true,status);
	}
	
	@Test
	public void deleteUserFailureTestCase()
	{
		boolean status = userDAO.delete("syed16@gmail.com");
		assertEquals("delete user failure test case",false,status);
	}
	
	@Test
	public void getAllUsersTestCase()
	{
		List<User> users=userDAO.list();
		assertEquals("get all users",5,users.size());
	}
	
	public void validateCredentialsTestCase()
	{
		user = userDAO.validate("syedshaha1996@gmail.com", "syed1996");
		assertNotNull("validate test case",user);
	}

}



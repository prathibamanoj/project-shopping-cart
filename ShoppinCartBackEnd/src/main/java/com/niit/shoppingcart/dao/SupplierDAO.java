package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.shoppingcart.domain.Supplier;

@Service
public interface SupplierDAO {
	
	public boolean save(Supplier supplier);
	
	public boolean update(Supplier supplier);
	
	public Supplier get(String emailID);
	
	public boolean delete(String emailID);
	
	public List<Supplier> list();
	
	/*public Supplier validate(String emailID,String password);
*/
}

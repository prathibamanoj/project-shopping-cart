package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

import antlr.collections.List;



public class SupplierController {
	
	//we need to call supplierDAO methods
	//get,save,update,delete,list
	
	//1.inject the supplierDAO and supplier
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	//http://localhost:8080/shoppingcart/supplier/get/cate_001
	@GetMapping("/supplier/get/{id}")
	public ModelAndView getsupplier(@RequestParam("id") String id)
	{
		//based on id,fetch the details from supplierDAO
		supplier = supplierDAO.get(id);
		
		//navigate to home page
		ModelAndView mv = new ModelAndView("home");
	mv.addObject("supplier",supplier);
	return mv;
	
	}
	
	@PostMapping("/supplier/save/")
	/*public ModelAndView savesupplier(@Requestparam("id") string id,
	 * @RequestParam("id") string name,
	 *         @Requestparam("id") string description)*/
	public ModelAndView savesupplier(@RequestBody Supplier supplier)
	{
		
		//navigate to home page
		ModelAndView mv = new ModelAndView("home");
		
		//call save method of supplierDAO
		if(supplierDAO.save(supplier)==true)
		{
			//add success message
			mv.addObject("successMessage", "The supplier saved successfully");
		}
		else
		{
			//add failure message
			mv.addObject("errorMessage", "could not save the supplier,");
		}
		return mv;
	}
	@PutMapping("supplier/update/")
	public ModelAndView updatesupplier(@RequestBody Supplier supplier)
	{
		
		//navigate to home page
		ModelAndView mv = new ModelAndView("home");
		
		//call save method of supplierDAO
		if(supplierDAO.update(supplier)==true)
		{
			//add success message
			mv.addObject("successMessage", "The supplier update successfully");
		}
		else
		{
			//add failure message
			mv.addObject("errorMessage", "could not update the supplier,");
		}
		return mv;
	}
	
	@DeleteMapping("/supplier/delete/{id}")
	public ModelAndView deletesupplier(@RequestParam("id") String id)
	{
		//navigate to home page
		ModelAndView mv = new ModelAndView("home");
		
		//based on id, fetch the details from supplierDAO
		if(supplierDAO.delete(id)==true)
		{
			//add success message
			mv.addObject("successMessage", "The supplier deleted successfully");
		}
		else
		{
			//add failure message
			mv.addObject("successMessage", "could not delete the supplier.");
			
		}
		return mv;
	}
	
		@GetMapping("/suppliers")
		public ModelAndView getAllCategories() {
		ModelAndView mv = new ModelAndView("home");
		List suppliers = (List) supplierDAO.list();
		mv.addObject("suppliers", suppliers);
		return mv;
		}

}
		
		
	
		
		
	
	
	



package com.niit.shoppingcart.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
@Controller
public class ProductController {

	// we need to call ProductDAO methods
	// get,save,update,delete,list

	// 1. inject the ProductDAO and Product
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Product product;
	
	@Autowired
	private Category category;
	
	@Autowired
	private Supplier supplier;
	
	
	@Autowired HttpSession httpSession;

	// http://localhost:8080/shoppingcart/product/get/cate_001
	// @GetMapping("/product/get/{id}")
	@RequestMapping(name = "/product/get/{id}", method = RequestMethod.GET)
	public ModelAndView getProduct(@RequestParam("id") String id) {
		// based on id, fetch the details from productDAO
		product = productDAO.get(id);

		// navigate to home page
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("product", product);
		return mv;

	}

	@PostMapping("/product/save/")
	/*
	 * public ModelAndView saveProduct(@RequestParam("id") String id,
	 * 
	 * @RequestParam("id") String name,
	 * 
	 * @RequestParam("id") String description)
	 */
	public ModelAndView saveProduct(@RequestParam("id") String id, 
			@RequestParam("name") String name,
			@RequestParam("description") String description, 
		    @RequestParam("price") String price,
		    @RequestParam("categoryID") String categoryID,
		    @RequestParam("supplierID") String supplierID)
	{
		    
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		//set the values to product
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		price = price.replace(",", "");
		product.setPrice(price);
		product.setCategory(categoryDAO.get(categoryID));
		product.setSupplier(supplierDAO.get(supplierID));
		//save into db
		if(productDAO.save(product))
		{
			mv.addObject("productSuccessMessage", "The product created successfully");
			//fetch all the products again 
	/*		List<Product> products = productDAO.list();
			//and set to http session.
			httpSession.setAttribute("products", products);
	*/	}
		else
		{
			mv.addObject("productErrorMessage", "Coulc not able to create product.  please contact admin");
		}
		return mv;

	}

	@PutMapping("/product/update/")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		// navigate to home page
		ModelAndView mv = new ModelAndView("home");

		// call save method of productDAO
		if (productDAO.update(product) == true) {
			// add success message
			mv.addObject("successMessage", "The product updated successfully");
		} else {
			// add failure message
			mv.addObject("errorMessage", "Could not update the product.");

		}
		return mv;

	}

	@GetMapping("/product/delete")
	public ModelAndView deleteProduct(@RequestParam String id) {
		System.out.println("going to delete product : " + id);
		// navigate to home page
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		//we supposed to fetch the latest products
		//and add to httpSession
		// based on id, fetch the details from productDAO
		if (productDAO.delete(id) == true) {
			// add success message
			mv.addObject("successMessage", "The product deleted successfully");

		} else {
			// add failure message
			mv.addObject("errorMessage", "Could not delete the product.");

		}

		return mv;

	}

	
	@GetMapping("/product/edit")
	public ModelAndView editProduct(@RequestParam String id)
	{
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		
		product = productDAO.get(id);
		
		httpSession.setAttribute("selectedProduct", product);
		return mv;
		
	}
	
	@GetMapping("/products")
	public ModelAndView getAllProducts() {
		ModelAndView mv = new ModelAndView("home");
		List<Product> products = productDAO.list();
		mv.addObject("products", products);
		return mv;
	}

}
package com.neu.online_shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.shopping_backend.dao.ProductDAO;
import com.neu.shopping_backend.dto.Product;


@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;
	

	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsList() {		
		return productDAO.list();
				
	}	
	
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		
		return productDAO.listActiveProducts();
				
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {
		
		return productDAO.listActiveProductsByCategory(id);
				
	}
	
	
	@RequestMapping("/mv/products")
	@ResponseBody
	public List<Product> getMostViewedProducts() {		
		return productDAO.getProductsByParam("views", 5);				
	}
		
	@RequestMapping("/mp/products")
	@ResponseBody
	public List<Product> getMostPurchasedProducts() {		
		return productDAO.getProductsByParam("purchases", 5);				
	}
	
	
	
	
}



//@Controller
//@RequestMapping("/json/data")
//public class JsonDataController {
//
//	@Autowired
//	private ProductDAO productDAO;
//	
//
////	@RequestMapping("/admin/all/products")
////	@ResponseBody
////	public List<Product> getAllProductsList() {		
////		return productDAO.list();
////				
////	}	
//	
//	
//	@RequestMapping("/all/products")
//	@ResponseBody
//	public List<Product> getAllProducts() {
//		
//		return productDAO.listActiveProducts();
//				
//	}
//	
//	@RequestMapping("/category/{id}/products")
//	@ResponseBody
//	public List<Product> getProductsByCategory(@PathVariable int id) {
//		
//		return productDAO.listActiveProductsByCategory(id);
//				
//	}
//	
//	
//	@RequestMapping("/mv/products")
//	@ResponseBody
//	public List<Product> getMostViewedProducts() {		
//		return productDAO.getProductsByParam("views", 5);				
//	}
//		
//	@RequestMapping("/mp/products")
//	@ResponseBody
//	public List<Product> getMostPurchasedProducts() {		
//		return productDAO.getProductsByParam("purchases", 5);				
//	}
//	
//	
//	
//	
//}

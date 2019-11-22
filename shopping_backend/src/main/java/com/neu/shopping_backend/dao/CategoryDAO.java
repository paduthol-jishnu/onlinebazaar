package com.neu.shopping_backend.dao;

import java.util.List;

import com.neu.shopping_backend.dto.Category;

public interface CategoryDAO {
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
	
	
	
	
	

}



/*Abstract method to get 
 * a single category by id
 *  in the PageController*/
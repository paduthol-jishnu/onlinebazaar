package com.neu.shopping_backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neu.shopping_backend.dao.CategoryDAO;
import com.neu.shopping_backend.dto.Category;



@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * Updating a single category
	 */
	@Override
	public boolean update(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}

	
	
	
	
	/* 
	 * Static list for testing
	 * 
	 * 
	 * 
private static List<Category> categories=new ArrayList<>();
//	static{
//		
//		
//		//adding first category
//		Category category=new Category();
//		category.setId(1);
//		category.setName("Television");
//		category.setDescription("This is some description of television");
//		category.setImageURL("Cat1.png");
//		
//		categories.add(category);
//		
//		
//		//Second Category
//		category=new Category();
//		category.setId(2);
//		category.setName("Mobile");
//		category.setDescription("This is some description of mobile");
//		category.setImageURL("Cat2.png");
//		
//		categories.add(category);
//	
//		//Third Category
//		category=new Category();
//		category.setId(3);
//		category.setName("Laptop");
//		category.setDescription("This is some description of laptop");
//		category.setImageURL("Cat3.png");
//		
//		categories.add(category);
//	
//	}
	*/
	
	
	
	


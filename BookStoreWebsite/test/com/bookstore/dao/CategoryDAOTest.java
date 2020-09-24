package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;

public class CategoryDAOTest extends BaseDAOTest{
	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		BaseDAOTest.setUpBeforeClass();
		categoryDAO = new CategoryDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();;
	}

	@Test
	public void testCreateCategory() {
		Category newCat = new Category("C#");
		Category category = categoryDAO.create(newCat);
		
		assertTrue(category != null && category.getCategoryId() > 0);
		
	}

	@Test
	public void testUpdateCategory() {
		
		Category newCat = new Category("Advanced Java");
		newCat.setCategoryId(2);
		
		Category  category = categoryDAO.update(newCat);
		
		assertEquals(newCat.getName(), category.getName());
	}

	@Test
	public void testGet() {
		Integer catId = 2;
		Category categoryId = categoryDAO.get(catId);
		
		assertNotNull(categoryId);
	}

	@Test
	public void testDeleteObject() {
		Integer catId = 6;
		categoryDAO.delete(catId);
		
		Category categoryId = categoryDAO.get(catId);
		assertNull(categoryId);
	}

	@Test
	public void testListAll() {
		List<Category> listCategories = categoryDAO.listAll();
		
		listCategories.forEach(c -> System.out.println(c.getName()+", "));
		assertTrue(listCategories.size() > 0);
	}

	@Test
	public void testCount() {
		long totalCategories = categoryDAO.count();
		
		assertEquals(totalCategories, 5);
		
	}

}

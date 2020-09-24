package com.bookstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryTest {
	public static void main(String[] args) {
		
		
		Category cat = new Category("Advanced Java");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
//		 Start transaction
		 entityManager.getTransaction().begin();
		 entityManager.persist(cat);
	//Save the transaction and close it
		 entityManager.getTransaction().commit();
		 entityManager.close();
		 
		 
		 entityManagerFactory.close();
		 
		 System.out.println("A Category Object was persisted");
	}

}

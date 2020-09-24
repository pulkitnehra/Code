package com.bookstore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class UsersTest {
	
	public static void main(String[] args) {
		
	 Users user1 = new Users();
	 user1.setEmail("bak@gmail.com");	
	 user1.setFullName("Jatta ve");
	 user1.setPassword("six6");
	 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
	 EntityManager entityManager = entityManagerFactory.createEntityManager();
	 
//	 Start transaction
	 entityManager.getTransaction().begin();
	 entityManager.persist(user1);
//Save the transaction and close it
	 entityManager.getTransaction().commit();
	 entityManager.close();
	 
	 entityManagerFactory.close();
	 
	 System.out.println("A User\'s Object was persisted");
	 
	 
	 
	}
	
	

}

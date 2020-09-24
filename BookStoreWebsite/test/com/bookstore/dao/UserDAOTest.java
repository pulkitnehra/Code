package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest extends BaseDAOTest{
	private static UserDAO usrdao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		BaseDAOTest.setUpBeforeClass();
		usrdao = new UserDAO(entityManager);
	}
	
	
//	Insert details of users
	@Test
	public void testCreateUsers() {
		
		Users usr = new Users();
		usr.setEmail("brody@jason.com");
		usr.setFullName("Jason Brody");
		usr.setPassword("brody123");
		
		usr = usrdao.create(usr);

		assertTrue(usr.getUserId() > 0);
	}
	
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldNotSet() 
	{
		
		Users usr = new Users();
				
		UserDAO usrdao = new UserDAO(entityManager);
		usr = usrdao.create(usr);
	}
	
	
	
//	Update details of users
	@Test
	public void testUpdateUsers() 
	{
		Users user = new Users();
		user.setUserId(1);
		user.setEmail("pn@gmail.com");
		user.setFullName("Pulkit");
		user.setPassword("777");
		
		user = usrdao.update(user);
		
		String expected = "777";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	}
	
	
	
	@Test
	public void testGetUsersFound() 
	{
		Integer userid = 1;
		Users user = usrdao.get(userid);
		
		if(user != null) {
		System.out.println(user.getEmail());
		}
		
		assertNotNull(user);
	}
	
	
	@Test
	public void testGetUsersNotFound() 
	{
		Integer userid = 101;
		Users user = usrdao.get(userid);
		
		
		assertNull(user);
	}
	
	
	@Test
	public void testDeleteUsers()
	{
		Integer userid = 8;
		usrdao.delete(userid);
		
		Users user = usrdao.get(userid);
		
		assertNull(user);
	}
	
	
	@Test(expected=EntityNotFoundException.class)
	public void testDeleteNonExistentUsers()
	{
		Integer userid = 8;
		usrdao.delete(userid);
		
		
	}
	
	
	@Test
	public void testListAll()
	{
		List<Users> listall = usrdao.listAll();
	
		assertTrue(listall.size() > 0);
	}
	
	
	
	@Test
	public void testCountAllUsers()
	{
		long totalUsers = usrdao.count();
		
		assertEquals(3, totalUsers);
	}
	
	
	
	@Test
	public void testFindByEmail()
	{
		String email = "jagga@daku.com";
		Users user = usrdao.findByEmail(email);
		
		assertNotNull(user);
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		BaseDAOTest.tearDownAfterClass();
		
	}
	

}

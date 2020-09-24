package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users>{

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	
	public Users create(Users users) 
	{
		return super.create(users);
	}
	
	@Override
	public Users update(Users users) {
		
		return super.update(users);
	}

	@Override
	public Users get(Object userid) {
		// TODO Auto-generated method stub
		return super.find(Users.class, userid);
	}

	@Override
	public void delete(Object userid) {
		// TODO Auto-generated method stub
		 super.delete(Users.class, userid);
		
		
	}

	@Override
	public List<Users> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.countWithNamedQuery("Users.countAll");

	}

	
	public Users findByEmail(String email)
	{
        List<Users> listByEmail = super.findWithNamedQuery("Users.findbyEmail","email",email);
		
//        if the email address is unique
        if(listByEmail != null && listByEmail.size()>0)
        {
        	return listByEmail.get(0);
        }
        
        return null;
	}
	
	
	
	
}

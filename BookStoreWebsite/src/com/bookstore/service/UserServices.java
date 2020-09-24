package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

public class UserServices {
	
	private UserDAO userdao;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private EntityManager entityManager;
	
	public UserServices(HttpServletRequest request,EntityManager entityManager, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		
		userdao = new UserDAO(entityManager);
		
		
	
	}
	
	public void listUser() throws ServletException, IOException
	{
		listUser(null);
	}
	
	
	
	public void listUser(String message) throws ServletException, IOException
	{
		List<Users> listUsers = userdao.listAll();
		request.setAttribute("listusers",listUsers);
		if(message != null) {
			request.setAttribute("message",message);
		}
		String path = "user_list.jsp";
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
		
	}

	public void createUser() throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		Users existingUser = userdao.findByEmail(email);
		
		if(existingUser != null)
		{
			String message = "Unable to create user. A User with the email: "+email+" already exists.";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
			
			
		}else {
		
		Users newUser = new Users(email, fullName, password);
		userdao.create(newUser);
		listUser("New user created successfully!!");
		}
		
	}
	
	public void editUser() throws ServletException, IOException
	{
		Integer userId = Integer.parseInt(request.getParameter("id"));
		Users user = userdao.get(userId);
		
		
		String edit_page = "user_form.jsp";
		request.setAttribute("user",user);
		RequestDispatcher dispatcher = request.getRequestDispatcher(edit_page);
		dispatcher.forward(request, response);
		
		
	}

	public void updateUser() throws ServletException, IOException {
		Integer userID = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		
		Users userById = userdao.get(userID);
		Users userByEmail = userdao.findByEmail(email);
		
//		if found a same email at 2 different user id locations
		if(userByEmail != null && userByEmail.getUserId() != userById.getUserId())
		{
			String message = "Could not update user. User with email "+email+" exists	";
			request.setAttribute("message", message);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
			
			
		}else {
		
		Users users = new Users(userID, email,fullname,password);
		userdao.update(users);
		
		String message = "Users has been updated successfully!!";
		listUser(message);
		}
		
	}

	public void deleteUser() throws ServletException, IOException {
		
//		here id is name of parameter after delete_user?
		int usersId = Integer.parseInt(request.getParameter("id"));
		userdao.delete(usersId);
		
		
		String msg = "User deleted Successfully!";
		listUser(msg);
	}
	
	
	
}

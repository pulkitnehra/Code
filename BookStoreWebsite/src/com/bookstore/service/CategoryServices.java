package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.admin.user.ListUserServlet;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Category;

public class CategoryServices {
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private EntityManager entityManager;
	public CategoryServices(HttpServletRequest request,EntityManager entityManager, HttpServletResponse response) {
		super();
		this.request = request;
		this.entityManager = entityManager;
		this.response = response;
		
		categoryDAO = new CategoryDAO(entityManager);
		
	}


	public void listCategory() throws ServletException, IOException {
		
		List<Category> listcategory = categoryDAO.listAll();
		request.setAttribute("listcategory", listcategory);
		String path = "category_list.jsp";
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}
	
	
	
	
	
}

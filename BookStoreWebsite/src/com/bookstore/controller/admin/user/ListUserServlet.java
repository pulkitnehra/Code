package com.bookstore.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.entity.Users;
import com.bookstore.service.UserServices;

@WebServlet("/admin/user_list")
public class ListUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServices userservices = new UserServices(request,entityManager, response);
		userservices.listUser();
	}

	

}

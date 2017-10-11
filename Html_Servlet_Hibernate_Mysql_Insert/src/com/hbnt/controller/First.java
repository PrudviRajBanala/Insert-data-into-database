package com.hbnt.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hbnt.dao.FirstDAO;

/**
 * Servlet implementation class First
 */
//@WebServlet("/index")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name  = request.getParameter("name");
		String pass  = request.getParameter("password");
		
		System.out.println("name is " + name);
		System.out.println("password is " + pass);
		
		HttpSession session = request.getSession(true);
		try {
			FirstDAO firstDAO = new FirstDAO();
			firstDAO.addFirstDetails(name, pass);
			response.sendRedirect("Success");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}

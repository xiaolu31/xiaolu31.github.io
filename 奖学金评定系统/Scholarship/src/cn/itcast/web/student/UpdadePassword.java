package cn.itcast.web.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.db.Process_admin;

public class UpdadePassword extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password=request.getParameter("pasword");
		String username=(String) request.getSession().getAttribute("username");
		Process_admin poan=new Process_admin();
		poan.updatepassword(password, username);
		request.getSession().setAttribute("tishi", "ÐÞ¸ÄÃÜÂë³É¹¦");
		request.getRequestDispatcher("/UpdatePassword.jsp").forward(request, response);
		
		
		

		
	}

	


}

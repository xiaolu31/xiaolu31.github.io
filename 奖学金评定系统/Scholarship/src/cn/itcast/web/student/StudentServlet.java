package cn.itcast.web.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.db.Denglu;

public class StudentServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("textfield");
		String password=request.getParameter("textfield2");
		String status=request.getParameter("status");
		Denglu denglu=new Denglu();
		if(status.equals("0")){
		boolean flag=denglu.find(username, password);
		if(flag){
			request.getSession().setAttribute("username", username);
			//System.out.println("username");
			request.getRequestDispatcher("/index.htm").forward(request, response);
			
		}else{
			request.getSession().setAttribute("denglu", "failure");
			response.sendRedirect("/Scholarship/login.jsp");
		}
		}else if(status.equals("1")){
			if(username.equals("admin")&password.equals("123")){
			request.getRequestDispatcher("/admin/index_1.html").forward(request, response);
			}else
			{
				response.sendRedirect("/Scholarship/login.jsp");
			}
		}
		
		

		
	}

}

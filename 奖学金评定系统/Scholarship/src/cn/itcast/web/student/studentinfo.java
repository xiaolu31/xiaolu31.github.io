package cn.itcast.web.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.db.Denglu;
import cn.itcast.web.domain.Student;

public class studentinfo extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");
		Denglu denglu=new Denglu();
		List<Student> liststudent=new ArrayList<Student>();
		liststudent=denglu.find(username);
		request.setAttribute("liststudent",liststudent);
		request.getRequestDispatcher("/studentinfo.jsp").forward(request, response);

		
	}

}

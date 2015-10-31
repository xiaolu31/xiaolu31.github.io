package cn.itcast.web.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.db.Process_admin;
import cn.itcast.web.domain.Student;

public class Downgrade_detail extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Process_admin poc=new Process_admin();
		List<Student> downgrade_id_detail=new ArrayList<Student>();
		downgrade_id_detail=poc.downgrade_detail();
		
		//System.out.println(111);
		request.getSession().setAttribute("downgrade_id_detail", downgrade_id_detail);
		request.getRequestDispatcher("/admin/downgrade_detail.jsp").forward(request, response);

	
	}

}

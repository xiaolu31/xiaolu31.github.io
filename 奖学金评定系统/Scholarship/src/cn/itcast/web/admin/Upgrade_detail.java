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

public class Upgrade_detail extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Process_admin poca=new Process_admin();
		List<Student> upgrade_id_detail=new ArrayList<Student>();
		upgrade_id_detail=poca.upgrade_detail();
		/*for(int i=0;i<upgrade_id_detail.size();i++){
			String id=upgrade_id_detail.get(i).getId();
			double coursegrade=upgrade_id_detail.get(i).getCoursegrade();
			System.out.println(111);
			System.out.println(id+"----"+coursegrade);
		}
		//System.out.println(111);*/
		request.getSession().setAttribute("upgrade_id_detail", upgrade_id_detail);
		request.getRequestDispatcher("/admin/upgrade_detail.jsp").forward(request, response);

		
	}

}

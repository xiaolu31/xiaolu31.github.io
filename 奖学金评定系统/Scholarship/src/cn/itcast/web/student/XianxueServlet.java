package cn.itcast.web.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.db.Grade;

public class XianxueServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username=(String) request.getSession().getAttribute("username");
		 String counter_xianxue = URLDecoder.decode(request.getParameter("xianxue_counter"),
			"UTF-8");     
	     String[] xx_counter=counter_xianxue.split(",");//这个是前台提交上来的职务类型组成的数组
	     for(int i=0;i<xx_counter.length;i++){
	    	 System.out.println(xx_counter[i]);
	     }
	     Grade grade=new Grade();
	     grade.insert_tb_student(username,xx_counter);
	     request.getRequestDispatcher("/xianxue/success.jsp").forward(request, response);

		
	}

}

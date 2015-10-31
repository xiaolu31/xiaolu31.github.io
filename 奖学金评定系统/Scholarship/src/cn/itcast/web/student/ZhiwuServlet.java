package cn.itcast.web.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.db.Grade;

public class ZhiwuServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username=(String) request.getSession().getAttribute("username");
		 String positionType = URLDecoder.decode(request.getParameter("positionType"),
			"UTF-8"); 
		 String positionDetail = URLDecoder.decode(request.getParameter("strname"),
			"UTF-8"); 
	     String[] pstType=positionType.split(",");//这个是前台提交上来的职务类型组成的数组
	     String[] pstDetail=positionDetail.split(",");
	     double sum_position=0;
	     Grade grade=new Grade();
	     grade.insert_positiontable(username,pstType,pstDetail);
	     for(int i=0;i<pstType.length;i++){
	    	 String str_1=pstType[i];
	    	 double sum=0;
	    	 if(str_1.equals("校研究生会主席、研究生工作部主任、团委书记、辅导员")){
	    		 sum=50;
	    	 }else if(str_1.equals("校研究生会副主席，学部研究生会主席，学部研究生工作部主任")){
	    		 sum=40;
	    		 
	    	 }else if(str_1.equals("学部研究生会副主席、团委副书记、各班班长、党支书、团支书")){
	    		 sum=30;
	    	 }else if(str_1.equals("学部研究生会办公室主任、部长、校研究生会各部部长")){
	    		 sum=20;
	    	 }else if(str_1.equals("其他干部")){
	    		 sum=10;
	    	 }
	    	 sum_position+=sum;
	     }
	     grade.update_student_position(username, sum_position);
	     request.getRequestDispatcher("/zhiwu/success.jsp").forward(request, response);
	}

}

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
	     String[] pstType=positionType.split(",");//�����ǰ̨�ύ������ְ��������ɵ�����
	     String[] pstDetail=positionDetail.split(",");
	     double sum_position=0;
	     Grade grade=new Grade();
	     grade.insert_positiontable(username,pstType,pstDetail);
	     for(int i=0;i<pstType.length;i++){
	    	 String str_1=pstType[i];
	    	 double sum=0;
	    	 if(str_1.equals("У�о�������ϯ���о������������Ρ���ί��ǡ�����Ա")){
	    		 sum=50;
	    	 }else if(str_1.equals("У�о����ḱ��ϯ��ѧ���о�������ϯ��ѧ���о�������������")){
	    		 sum=40;
	    		 
	    	 }else if(str_1.equals("ѧ���о����ḱ��ϯ����ί����ǡ�����೤����֧�顢��֧��")){
	    		 sum=30;
	    	 }else if(str_1.equals("ѧ���о�����칫�����Ρ�������У�о������������")){
	    		 sum=20;
	    	 }else if(str_1.equals("�����ɲ�")){
	    		 sum=10;
	    	 }
	    	 sum_position+=sum;
	     }
	     grade.update_student_position(username, sum_position);
	     request.getRequestDispatcher("/zhiwu/success.jsp").forward(request, response);
	}

}

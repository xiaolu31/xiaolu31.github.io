package cn.itcast.web.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.db.Grade;

public class HuodongServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");
		 String strname = URLDecoder.decode(request.getParameter("strname"),
			"UTF-8");
		 String strtype1 = URLDecoder.decode(request.getParameter("strtype1"),
			"UTF-8");
	     String strtype2 = URLDecoder.decode(request.getParameter("strtype2"),
			"UTF-8");        
	     String[] activityType=strtype1.split(",");//�����ǰ̨�ύ�������ڿ�������ɵ�����
	     String[] activitylayer=strtype2.split(",");//�����ǰ̨�ύ�������ڿ�����������ɵ�����
	     String[] activitydetail=strname.split(",");
	     boolean flag=true;
	     double sum_activity=0;
	     for (int i=0;i<activityType.length;i++){
	    	 if(activityType[i].equals("a0") || activitylayer[i].equals("a0")){
	    		flag=false;
	    	 }
	     }
	     if(!flag){
	    	 request.getRequestDispatcher("/huodong/huodong.jsp").forward(request, response);
	     }else{
	    	 Grade grade=new Grade();
		     grade.insert_huodong(username,activityType, activitylayer, activitydetail);
		     for(int i=0;i<activityType.length;i++){
		    	 double sum=0;
		 	    	String str_1=activityType[i];
		 	    	String str_2=activitylayer[i];
		 	    	if(str_1.equals("����")&str_2.equals("һ�Ƚ�")){
		 	    		sum=50;
		 	    	}else if(str_1.equals("����")&str_2.equals("���Ƚ�")){
		 	    		sum=30;
		 	    	}else if(str_1.equals("����")&str_2.equals("���Ƚ�")){
		 	    		sum=20;
		 	    	}else if(str_1.equals("����")&str_2.equals("���Ƚ�����")){
		 	    		sum=5;
		 	    	}else if(str_1.equals("ʡ")&str_2.equals("һ�Ƚ�")){
		 	    		sum=30;
		 	    	}else if(str_1.equals("ʡ")&str_2.equals("���Ƚ�")){
		 	    		sum=20;
		 	    	}else if(str_1.equals("ʡ")&str_2.equals("���Ƚ�")){
		 	    		sum=15;
		 	    	}else if(str_1.equals("ʡ")&str_2.equals("���Ƚ�����")){
		 	    		sum=4;
		 	    	}else if(str_1.equals("��")&str_2.equals("һ�Ƚ�")){
		 	    		sum=20;
		 	    	}else if(str_1.equals("��")&str_2.equals("���Ƚ�")){
		 	    		sum=15;
		 	    	}else if(str_1.equals("��")&str_2.equals("���Ƚ�")){
		 	    		sum=10;
		 	    	}else if(str_1.equals("��")&str_2.equals("���Ƚ�����")){
		 	    		sum=3;
		 	    	}else if(str_1.equals("У")&str_2.equals("һ�Ƚ�")){
		 	    		sum=10;
		 	    	}else if(str_1.equals("У")&str_2.equals("���Ƚ�")){
		 	    		sum=6;
		 	    	}else if(str_1.equals("У")&str_2.equals("���Ƚ�")){
		 	    		sum=4;
		 	    	}else if(str_1.equals("У")&str_2.equals("���Ƚ�����")){
		 	    		sum=2;
		 	    	}
		 	    	sum_activity+=sum;
		 	     }
		     grade.update_student_huodong(username, sum_activity);
		     request.getRequestDispatcher("/huodong/success.jsp").forward(request, response);

	     }
	     
		
	}

}

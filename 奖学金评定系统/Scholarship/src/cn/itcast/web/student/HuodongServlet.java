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
	     String[] activityType=strtype1.split(",");//这个是前台提交上来的期刊类型组成的数组
	     String[] activitylayer=strtype2.split(",");//这个是前台提交上来的期刊具体名称组成的数组
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
		 	    	if(str_1.equals("国家")&str_2.equals("一等奖")){
		 	    		sum=50;
		 	    	}else if(str_1.equals("国家")&str_2.equals("二等奖")){
		 	    		sum=30;
		 	    	}else if(str_1.equals("国家")&str_2.equals("三等奖")){
		 	    		sum=20;
		 	    	}else if(str_1.equals("国家")&str_2.equals("三等奖以下")){
		 	    		sum=5;
		 	    	}else if(str_1.equals("省")&str_2.equals("一等奖")){
		 	    		sum=30;
		 	    	}else if(str_1.equals("省")&str_2.equals("二等奖")){
		 	    		sum=20;
		 	    	}else if(str_1.equals("省")&str_2.equals("三等奖")){
		 	    		sum=15;
		 	    	}else if(str_1.equals("省")&str_2.equals("三等奖以下")){
		 	    		sum=4;
		 	    	}else if(str_1.equals("市")&str_2.equals("一等奖")){
		 	    		sum=20;
		 	    	}else if(str_1.equals("市")&str_2.equals("二等奖")){
		 	    		sum=15;
		 	    	}else if(str_1.equals("市")&str_2.equals("三等奖")){
		 	    		sum=10;
		 	    	}else if(str_1.equals("市")&str_2.equals("三等奖以下")){
		 	    		sum=3;
		 	    	}else if(str_1.equals("校")&str_2.equals("一等奖")){
		 	    		sum=10;
		 	    	}else if(str_1.equals("校")&str_2.equals("二等奖")){
		 	    		sum=6;
		 	    	}else if(str_1.equals("校")&str_2.equals("三等奖")){
		 	    		sum=4;
		 	    	}else if(str_1.equals("校")&str_2.equals("三等奖以下")){
		 	    		sum=2;
		 	    	}
		 	    	sum_activity+=sum;
		 	     }
		     grade.update_student_huodong(username, sum_activity);
		     request.getRequestDispatcher("/huodong/success.jsp").forward(request, response);

	     }
	     
		
	}

}

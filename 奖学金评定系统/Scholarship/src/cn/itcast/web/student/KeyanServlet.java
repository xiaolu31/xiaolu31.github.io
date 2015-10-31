package cn.itcast.web.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.db.Grade;

public class KeyanServlet extends HttpServlet {
	

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");
		 String strname1 = URLDecoder.decode(request.getParameter("strname1"),
			"UTF-8");
		 String strname2 = URLDecoder.decode(request.getParameter("strname2"),
			"UTF-8");
		 String strtype1= URLDecoder.decode(request.getParameter("strtype1"),
			"UTF-8");
	     String strtype2 = URLDecoder.decode(request.getParameter("strtype2"),
			"UTF-8");        
	     String[] paperType1=strtype1.split(",");//�����ǰ̨�ύ�������ڿ�������ɵ�����
	     String[] paperType2=strtype2.split(",");//�����ǰ̨�ύ�������ڿ�������ɵ�����
	     boolean flag=true;
	     String[] paperName1=strname1.split(",");//�����ǰ̨�ύ�������ڿ�����������ɵ�����
	     String[] paperName2=strname2.split(",");
	    double sum_keyan=0;
	     for(int i=0;i<paperType2.length;i++){
	    	 if(paperType2[i].equals("a0")){
	    		flag=false;
	    	 }
	     }
	     if(!flag){
	    	 request.getRequestDispatcher("/keyan/keyan.jsp").forward(request, response);
	     }else{
	    	  Grade grade=new Grade();
	 	     grade.insert_keyan(username,paperName1, paperName2,paperType1, paperType2);
	 	     for(int i=0;i<paperType1.length;i++){
	 	    	String str_1=paperType2[i];
	 	    	double sum=0;
	 	    	int str=-1;
	 	    	if(str_1.equals("����Top�ڿ�")){
	 	    		str=0;
	 	    	}else if(str_1.equals("����A���ڿ�")){
	 	    		str=1;
	 	    	}else if(str_1.equals("����B���ڿ�")){
	 	    		str=2;
	 	    	}else if(str_1.equals("����C���ڿ�������TOP�ڿ�")){
	 	    		str=3;
	 	    	}else if(str_1.equals("ȫ�����Ű�����ר��")){
	 	    		str=4;
	 	    	}else if(str_1.equals("����A���ڿ�")){
	 	    		str=5;
	 	    	}else if(str_1.equals("����B���ڿ�")){
	 	    		str=6;
	 	    	}else if(str_1.equals("����C���ڿ�")){
	 	    		str=7;
	 	    	}else if(str_1.equals("����")){
	 	    		str=8;
	 	    	}
	 	    	System.out.println(str);
	 	    	String str_2=paperType1[i];
	 	    	switch (str){
	 	    	case 0:
	 	    		sum=320;
	 	    		break;
	 	    	case 1:
	 	    		sum=160;
	 	    		break;
	 	    	case 2:
	 	    		sum=80;
	 	    		break;
	 	    	case 3:
	 	    		sum=40;
	 	    		break;
	 	    	case 4:
	 	    		sum=30;
	 	    		break;
	 	    	case 5:
	 	    		sum=20;
	 	    		break;
	 	    	case 6:
	 	    		sum=10;
	 	    		break;
	 	    	case 7:
	 	    		sum=5;
	 	    		break;
	 	    	case 8:
	 	    		sum=1;
	 	    		break;
	 	    	}
	 	    	System.out.println(sum);
	 	    	if(str_2.equals("��һ����")){
	 	    		sum=sum*1;
	 	    	}else if(str_2.equals("�ڶ�����")){
	 	    		sum=sum*0.5;
	 	    	}else {
	 	    		sum=sum*0.2;
	 	    	}
	 	    	sum_keyan=sum_keyan+sum; 
	 	     }
	 	     //System.out.println(sum_keyan);
	 	     grade.insert_keyan_student(username, sum_keyan);
	 	     request.getRequestDispatcher("/keyan/success.jsp").forward(request, response);
	     }
	    
	     
	     
	     
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		
	}

}

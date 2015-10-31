package cn.itcast.web.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.db.Grade;
import cn.itcast.web.domain.Grade_bean;
import cn.itcast.web.domain.StudentGrade;

public class tijiao_chengji extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		//System.out.println("method"+method);
		if(method!=null){
				this.submit_grade(request,response);		
		}else{
			this.option_grade(request,response);
		}
	}

	private void option_grade(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");
		Grade grade=new Grade();
		List<StudentGrade> student_grade_submit=new ArrayList<StudentGrade>();
		//student_grade=grade.find(username);
		
	//	for(int i=0;i<student_grade.size();i++){
	//		System.out.println(student_grade.get(i).getCourse_id());
		//}
		student_grade_submit=grade.find(username);
		request.setAttribute("student_grade_submit",student_grade_submit);
		request.getRequestDispatcher("/tijiao_grade.jsp").forward(request, response);
		
		
	}
	 public static double round(double value, int scale, int roundingMode) {  
	        BigDecimal bd = new BigDecimal(value);  
	        bd = bd.setScale(scale, roundingMode);  
	        double d = bd.doubleValue();  
	        bd = null;  
	        return d;  
	    }  

	private void submit_grade(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String username=(String) request.getSession().getAttribute("username");
		String temp=request.getParameter("ids");
		//System.out.println("temp"+temp);
		String[] ids=temp.split("_");
		Grade grade=new Grade();
		Map<String,String> map=new HashMap<String,String>();
		map=grade.submit_grade(ids);
		int counter_1=0;
		int counter_2=0;
		int counter_3=0;
		
		for(Map.Entry<String ,String> entry : map.entrySet()){  
			 String str=entry.getValue();
			 if(str.equals("公共必修课")){
				 counter_1=counter_1+1;
				 
			 }else if((str).equals("大类基础课")||(str).equals("专业基础课")){
				 counter_2=counter_2+1;
			 }else if(str.equals("专业选修课")){
				 counter_3=counter_3+1;
			 }
			} 
		if (counter_1==4&counter_2==5&counter_3==2){
			grade.insert_character(map, username);
			List<Grade_bean> sclist=new ArrayList<Grade_bean>();
			sclist=grade.insert_grade_bean(username);
			double sum_1=0;
			double sum_2=0;
			double avg_1=0;
			int counter_4=0;
			for(int i=0;i<sclist.size();i++){
				sum_1=sum_1+sclist.get(i).getGrade()*sclist.get(i).getCredit();
				sum_2=sum_2+sclist.get(i).getCredit();
				System.out.println(sclist.get(i).getLayer());
				if(sclist.get(i).getLayer().equals("C")){
					counter_4++;
				}
			}
			avg_1=sum_1/sum_2;
			avg_1=round(avg_1,2,BigDecimal.ROUND_DOWN);
			//System.out.println(sum_1+"--"+sum_2+"----"+avg_1+"---"+counter_4);
			grade.update_tb_student_id(username, avg_1, counter_4);
			request.getRequestDispatcher("/tijiao_chengji/success.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/tijiao_chengji/fail.jsp").forward(request, response);
		}
	}

}

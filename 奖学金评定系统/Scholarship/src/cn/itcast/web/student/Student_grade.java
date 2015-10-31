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
import cn.itcast.web.db.Grade;
import cn.itcast.web.domain.StudentGrade;

public class Student_grade extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");
		Grade grade=new Grade();
		List<StudentGrade> student_grade=new ArrayList<StudentGrade>();
		//student_grade=grade.find(username);
		
	//	for(int i=0;i<student_grade.size();i++){
	//		System.out.println(student_grade.get(i).getCourse_id());
		//}
		student_grade=grade.find(username);
		request.setAttribute("student_grade",student_grade);
		request.getRequestDispatcher("/student_grade.jsp").forward(request, response);
		

		
	}

}

package cn.itcast.web.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.db.Grade;
import cn.itcast.web.domain.ActivityDetail;
import cn.itcast.web.domain.Position_beans;
import cn.itcast.web.domain.StudentGrade;
import cn.itcast.web.domain.keyan;

public class jiangxuejingrade extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");
		List<keyan> keyanlist=new ArrayList<keyan>();
		List<StudentGrade> gradelist=new ArrayList<StudentGrade>();
		List<ActivityDetail> activitylist=new ArrayList<ActivityDetail>();
		List<Position_beans> positionlist=new ArrayList<Position_beans>();
		Grade grade=new Grade();
		keyanlist=grade.getKeyan(username);
		activitylist=grade.getActivity(username);
		positionlist=grade.getPosition(username);
		gradelist=grade.getCourse(username);
		double xianxue_counter=grade.get_xianxue(username);
		request.getSession().setAttribute("keyanlist", keyanlist);
		request.getSession().setAttribute("activitylist", activitylist);
		request.getSession().setAttribute("positionlist", positionlist);
		request.getSession().setAttribute("gradelist", gradelist);
		request.getSession().setAttribute("xianxue_counter", xianxue_counter);
		request.getRequestDispatcher("/jiangxuejin.jsp").forward(request, response);
	}

}

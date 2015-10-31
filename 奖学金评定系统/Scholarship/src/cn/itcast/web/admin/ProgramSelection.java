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
import cn.itcast.web.domain.Selection_option;
import cn.itcast.web.domain.Student;

public class ProgramSelection extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String planoption=request.getParameter("plan");
		//System.out.println(planoption);
		String first_counter=request.getParameter("first_counter");
		//System.out.println(first_counter);
		String second_counter=request.getParameter("second_counter");
		//System.out.println(second_counter);
		String three_counter=request.getParameter("three_counter");
		String four_counter=request.getParameter("four_counter");
		
		String input1=request.getParameter("input1");
		System.out.println(input1);
		String input2=request.getParameter("input2");
		//System.out.println(input2);
		String input3=request.getParameter("input3");
		//System.out.println(input3);
		Process_admin pos=new Process_admin();
		Selection_option selection=new Selection_option();
		selection.setPlanoption(planoption);
		selection.setFirst_counter(first_counter);
		selection.setSecond_counter(second_counter);
		selection.setThree_counter(three_counter);
		selection.setFour_counter(four_counter);
		selection.setInput1(input1);
		selection.setInput2(input2);
		selection.setInput3(input3);
		boolean flag=false;
		String outcome_admin="";
		if(planoption.equals("方案一")){
			flag=pos.process_plan(input1, input2, input3);
			if(flag){
			 outcome_admin="方案1生成成功，计算完毕.";
			}else {
				 outcome_admin="输入权重和不为1，请重新输入值.";
			}
			List<Student> scholarlist=new ArrayList<Student>();
			
			
			List<String> upgrade_id_first=new ArrayList<String>();
			List<String> upgrade_id_second=new ArrayList<String>();
			upgrade_id_first=pos.upgrade_scholar_first(first_counter);
			upgrade_id_second=pos.upgrade_scholar_second(second_counter);
			pos.upgrade_scholar_first(upgrade_id_first);
			pos.upgrade_scholar_second(upgrade_id_second);
			pos.downgrade_scholar_first();
			pos.down_scholar_second();
			scholarlist=pos.show_scholar_grade();
			request.getSession().setAttribute("scholarlist", scholarlist);
			selection.setOutcome_admin(outcome_admin);
			request.getSession().setAttribute("selection", selection);
			response.sendRedirect("/Scholarship/admin/ProgramSelection.jsp");
		}else if(planoption.equals("方案二")){
			flag=pos.process_plan(input1, input2, input3);
			if(flag){
			 outcome_admin="方案2生成成功，计算完毕.";
			}else {
				 outcome_admin="输入权重和不为1，请重新输入值.";
			}
			List<Student> scholarlist=new ArrayList<Student>();
			List<String> upgrade_id_first=new ArrayList<String>();
			List<String> upgrade_id_second=new ArrayList<String>();
			List<String> upgrade_id_first_must1=new ArrayList<String>();
			List<String> upgrade_id_second_must2=new ArrayList<String>();
			upgrade_id_first=pos.upgrade_scholar_first2();
			upgrade_id_second=pos.upgrade_scholar_second2();
			upgrade_id_first_must1=pos.upgrade_scholar_first2(first_counter);
			upgrade_id_second_must2=pos.upgrade_scholar_second2(second_counter);
			pos.upgrade_scholar_first2(upgrade_id_first);
			pos.upgrade_scholar_second2(upgrade_id_second);
			pos.upgrade_scholar_first_must1(upgrade_id_first_must1);
			pos.upgrade_scholar_second_must2(upgrade_id_second_must2);
			pos.downgrade_scholar_first(three_counter);
			pos.down_scholar_second(four_counter);
			scholarlist=pos.show_scholar_grade();
			request.getSession().setAttribute("scholarlist", scholarlist);
			selection.setOutcome_admin(outcome_admin);
			request.getSession().setAttribute("selection", selection);
			response.sendRedirect("/scholarship/admin/ProgramSelection.jsp");
		}
		
	}
	
	

}

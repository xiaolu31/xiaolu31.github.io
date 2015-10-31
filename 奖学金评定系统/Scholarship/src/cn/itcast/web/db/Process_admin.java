package cn.itcast.web.db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.itcast.web.domain.Grade_bean;
import cn.itcast.web.domain.Student;
import cn.itcast.web.util.JdbcUtil;

public class Process_admin {
	  public static double round(double value, int scale, int roundingMode) {  
	        BigDecimal bd = new BigDecimal(value);  
	        bd = bd.setScale(scale, roundingMode);  
	        double d = bd.doubleValue();  
	        bd = null;  
	        return d;  
	    }  
	public boolean process_plan(String input1,String input2,String input3){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		float input_1=Float.parseFloat(input1);
		float input_2=Float.parseFloat(input2);
		float input_3=Float.parseFloat(input3);
		double sum_jiangxuejin=0;
		boolean flag=false;
		if(input_1+input_2+input_3==1){
			flag=true;
		}
		if(flag){
		String sql="select id,coursegrade,xianxue_counter,sum_keyan,sum_activity,sum_position from tb_student";
		String sql_1 = "update tb_student set sum_jiangxuejin=? where id=?";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				String username=rs.getString("id");
				double coursegrade=rs.getDouble("coursegrade");
				double xianxue_counter=rs.getDouble("xianxue_counter");
				double sum_keyan=rs.getDouble("sum_keyan");
				double sum_activity=rs.getDouble("sum_activity");
				double sum_position=rs.getDouble("sum_position");
				pstmt = conn.prepareStatement(sql_1);
				sum_jiangxuejin=coursegrade*input_1+sum_keyan*input_2+(xianxue_counter+sum_activity+sum_position)*input_3;
				 sum_jiangxuejin=round(sum_jiangxuejin,3,BigDecimal.ROUND_HALF_UP);
				pstmt.setDouble(1, sum_jiangxuejin);
			   
			    pstmt.setString(2, username);
			    pstmt.executeUpdate();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}}
		else{
			return flag;
		}
		return flag;
	}
	@Test
	public void show(){
		float d1=0.7f;
		float d2=0.2f;
		float d3=0.1f;
		float d4=d1+d2+d3;
		System.out.println(d4);
	}
	public List<Student> show_scholar_grade(){
		List<Student> scholarlist=new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id,coursegrade,gradelayer,xianxue_counter,sum_keyan,sum_activity,sum_position,scholar_layer_old,scholar_layer_new,sum_jiangxuejin from tb_student  order by sum_jiangxuejin desc";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Student scholar_grade=new Student();
					String id=rs.getString("id");
					double coursegrade=rs.getDouble("coursegrade");
					double gradelayer=rs.getDouble("gradelayer");
					double xianxue_counter=rs.getDouble("xianxue_counter");
					double sum_keyan=rs.getDouble("sum_keyan");
					double sum_activity=rs.getDouble("sum_activity");
					double sum_position=rs.getDouble("sum_position");
					String scholar_layer_old=rs.getString("scholar_layer_old");
					String scholar_layer_new=rs.getString("scholar_layer_new");
					double sum_jiangxuejin=rs.getDouble("sum_jiangxuejin");
					scholar_grade.setId(id);
					scholar_grade.setCoursegrade(coursegrade);
					scholar_grade.setGradelayer(gradelayer);
					scholar_grade.setXianxue_counter(xianxue_counter);
					scholar_grade.setSum_keyan(sum_keyan);
					scholar_grade.setSum_activity(sum_activity);
					scholar_grade.setSum_position(sum_position);
					scholar_grade.setScholar_layer_old(scholar_layer_old);
					scholar_grade.setScholar_layer_new(scholar_layer_new);
					scholar_grade.setSum_jiangxuejin(sum_jiangxuejin);
					scholarlist.add(scholar_grade);
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
		
	return scholarlist;
	}
	public List<String> upgrade_scholar_first(String first_counter){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int first_count=Integer.parseInt(first_counter);
		List<String> upgrade_id_first=new ArrayList<String>();
		String sql="select id from tb_student where gradelayer=0 and scholar_layer_old=2 order by sum_jiangxuejin desc limit ?";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, first_count);
			rs=pstmt.executeQuery();
			while(rs.next()){
				String id=rs.getString("id");
				upgrade_id_first.add(id);
			}
			
			//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}	
	
			return upgrade_id_first;
	}
	public List<String> upgrade_scholar_second(String second_counter){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int second_count=Integer.parseInt(second_counter);
		List<String> upgrade_id_second=new ArrayList<String>();
		String sql="select id from tb_student where gradelayer=0 and scholar_layer_old=3 order by sum_jiangxuejin desc limit ?";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, second_count);
			rs=pstmt.executeQuery();
			while(rs.next()){
				String id=rs.getString("id");
				upgrade_id_second.add(id);
			}
			
			//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}	
	
			return upgrade_id_second;
	}
	public void upgrade_scholar_first(List<String> upgrade_id_first){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="update tb_student set scholar_layer_new=1 where id=?";
		String sql_1="update tb_student,jiangxuejin set scholar_layer_new=jiangxuejin_rank where id=jiangxuejin.tb_student_id";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql_1);
			pstmt.executeUpdate();
			//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<upgrade_id_first.size();i++){
			String id=upgrade_id_first.get(i);
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
			
		}
		
	}
	public void upgrade_scholar_second(List<String> upgrade_id_second){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="update tb_student set scholar_layer_new=2 where id=?";
		for(int i=0;i<upgrade_id_second.size();i++){
			String id=upgrade_id_second.get(i);
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
			
		}
		
	}
	public void downgrade_scholar_first(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<String> downgrade_id_first=new ArrayList<String>();
		List<String> downgrade_id_second=new ArrayList<String>();
		String sql="select id,scholar_layer_old from tb_student  order by sum_jiangxuejin asc limit 5";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				String id=rs.getString("id");
				String scholar_layer_old=rs.getString("scholar_layer_old");
				if(scholar_layer_old.equals("1")){
				downgrade_id_first.add(id);
				}
			}
			
			//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql_1="update tb_student set scholar_layer_new=2 where id=?";
		for(int i=0;i<downgrade_id_first.size();i++){
			String id=downgrade_id_first.get(i);
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql_1);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		downgrade_id_first.clear();
		///downgrade_id_second.clear();
		String sql_2="select id,scholar_layer_old from tb_student where gradelayer>=2 and scholar_layer_old=scholar_layer_new ";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql_2);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				String id=rs.getString("id");
				String scholar_layer_old=rs.getString("scholar_layer_old");
				//System.out.println(id);
				if(scholar_layer_old.equals("1")){
					downgrade_id_first.add(id);
					}else if(scholar_layer_old.equals("2")){
					downgrade_id_second.add(id);
					}
			}
			//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql_3="update tb_student set scholar_layer_new=2 where id=?";
		for(int i=0;i<downgrade_id_first.size();i++){
			String id=downgrade_id_first.get(i);
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql_3);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			String sql_4="update tb_student set scholar_layer_new=3 where id=?";
			for(int i=0;i<downgrade_id_second.size();i++){
				String id=downgrade_id_second.get(i);
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql_4);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
					//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
				} catch (Exception e) {
					e.printStackTrace();
				}
		finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}	
		}
	
			
	}
	public void down_scholar_second(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<String> downgrade_id_second=new ArrayList<String>();
		String sql="select id,scholar_layer_old from tb_student  order by sum_jiangxuejin asc limit 1";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				String id=rs.getString("id");
				String scholar_layer_old=rs.getString("scholar_layer_old");
				if(scholar_layer_old.equals("2")){
				downgrade_id_second.add(id);
				}
			}
			
			//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql_1="update tb_student set scholar_layer_new=3 where id=?";
		for(int i=0;i<downgrade_id_second.size();i++){
			String id=downgrade_id_second.get(i);
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql_1);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
		}
		
		
		

	}
		public List<Student> upgrade_detail(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			List<Student> upgrade_id_detail=new ArrayList<Student>();
			String sql="select id,coursegrade,gradelayer,xianxue_counter,sum_keyan,sum_activity,sum_position,scholar_layer_old,scholar_layer_new,sum_jiangxuejin from tb_student where  scholar_layer_old=2 and scholar_layer_new=1 ";
			String sql_1="select id,coursegrade,gradelayer,xianxue_counter,sum_keyan,sum_activity,sum_position,scholar_layer_old,scholar_layer_new,sum_jiangxuejin from tb_student where  scholar_layer_old=3 and scholar_layer_new=2 ";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Student student_upgrade_detail=new Student();
					String id=rs.getString("id");
					double coursegrade=rs.getDouble("coursegrade");
					double gradelayer=rs.getDouble("gradelayer");
					double xianxue_counter=rs.getDouble("xianxue_counter");
					double sum_keyan=rs.getDouble("sum_keyan");
					double sum_activity=rs.getDouble("sum_activity");
					double sum_position=rs.getDouble("sum_position");
					String scholar_layer_old=rs.getString("scholar_layer_old");
					String scholar_layer_new=rs.getString("scholar_layer_new");
					double sum_jiangxuejin=rs.getDouble("sum_jiangxuejin");
					student_upgrade_detail.setId(id);
					student_upgrade_detail.setCoursegrade(coursegrade);
					student_upgrade_detail.setGradelayer(gradelayer);
					student_upgrade_detail.setXianxue_counter(xianxue_counter);
					student_upgrade_detail.setSum_keyan(sum_keyan);
					student_upgrade_detail.setSum_activity(sum_activity);
					student_upgrade_detail.setSum_position(sum_position);
					student_upgrade_detail.setSum_jiangxuejin(sum_jiangxuejin);
					student_upgrade_detail.setScholar_layer_old(scholar_layer_old);
					student_upgrade_detail.setScholar_layer_new(scholar_layer_new);
					upgrade_id_detail.add(student_upgrade_detail);
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql_1);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Student student_upgrade_detail=new Student();
					String id=rs.getString("id");
					double coursegrade=rs.getDouble("coursegrade");
					double gradelayer=rs.getDouble("gradelayer");
					double xianxue_counter=rs.getDouble("xianxue_counter");
					double sum_keyan=rs.getDouble("sum_keyan");
					double sum_activity=rs.getDouble("sum_activity");
					double sum_position=rs.getDouble("sum_position");
					String scholar_layer_old=rs.getString("scholar_layer_old");
					String scholar_layer_new=rs.getString("scholar_layer_new");
					double sum_jiangxuejin=rs.getDouble("sum_jiangxuejin");
					student_upgrade_detail.setId(id);
					student_upgrade_detail.setCoursegrade(coursegrade);
					student_upgrade_detail.setGradelayer(gradelayer);
					student_upgrade_detail.setXianxue_counter(xianxue_counter);
					student_upgrade_detail.setSum_keyan(sum_keyan);
					student_upgrade_detail.setSum_activity(sum_activity);
					student_upgrade_detail.setSum_position(sum_position);
					student_upgrade_detail.setSum_jiangxuejin(sum_jiangxuejin);
					student_upgrade_detail.setScholar_layer_old(scholar_layer_old);
					student_upgrade_detail.setScholar_layer_new(scholar_layer_new);
					upgrade_id_detail.add(student_upgrade_detail);
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
		
			return upgrade_id_detail;
	}
		public List<Student> downgrade_detail(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			List<Student> downgrade_id_detail=new ArrayList<Student>();
			String sql="select id,coursegrade,gradelayer,xianxue_counter,sum_keyan,sum_activity,sum_position,scholar_layer_old,scholar_layer_new,sum_jiangxuejin from tb_student where  scholar_layer_old=1 and scholar_layer_new=2 ";
			String sql_1="select id,coursegrade,gradelayer,xianxue_counter,sum_keyan,sum_activity,sum_position,scholar_layer_old,scholar_layer_new,sum_jiangxuejin from tb_student where  scholar_layer_old=2 and scholar_layer_new=3 ";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Student student_downgrade_detail=new Student();
					String id=rs.getString("id");
					double coursegrade=rs.getDouble("coursegrade");
					double gradelayer=rs.getDouble("gradelayer");
					double xianxue_counter=rs.getDouble("xianxue_counter");
					double sum_keyan=rs.getDouble("sum_keyan");
					double sum_activity=rs.getDouble("sum_activity");
					double sum_position=rs.getDouble("sum_position");
					String scholar_layer_old=rs.getString("scholar_layer_old");
					String scholar_layer_new=rs.getString("scholar_layer_new");
					double sum_jiangxuejin=rs.getDouble("sum_jiangxuejin");
					student_downgrade_detail.setId(id);
					student_downgrade_detail.setCoursegrade(coursegrade);
					student_downgrade_detail.setGradelayer(gradelayer);
					student_downgrade_detail.setXianxue_counter(xianxue_counter);
					student_downgrade_detail.setSum_keyan(sum_keyan);
					student_downgrade_detail.setSum_activity(sum_activity);
					student_downgrade_detail.setSum_position(sum_position);
					student_downgrade_detail.setSum_jiangxuejin(sum_jiangxuejin);
					student_downgrade_detail.setScholar_layer_old(scholar_layer_old);
					student_downgrade_detail.setScholar_layer_new(scholar_layer_new);
					downgrade_id_detail.add(student_downgrade_detail);
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql_1);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Student student_downgrade_detail=new Student();
					String id=rs.getString("id");
					double coursegrade=rs.getDouble("coursegrade");
					double gradelayer=rs.getDouble("gradelayer");
					double xianxue_counter=rs.getDouble("xianxue_counter");
					double sum_keyan=rs.getDouble("sum_keyan");
					double sum_activity=rs.getDouble("sum_activity");
					double sum_position=rs.getDouble("sum_position");
					String scholar_layer_old=rs.getString("scholar_layer_old");
					String scholar_layer_new=rs.getString("scholar_layer_new");
					double sum_jiangxuejin=rs.getDouble("sum_jiangxuejin");
					student_downgrade_detail.setId(id);
					student_downgrade_detail.setCoursegrade(coursegrade);
					student_downgrade_detail.setGradelayer(gradelayer);
					student_downgrade_detail.setXianxue_counter(xianxue_counter);
					student_downgrade_detail.setSum_keyan(sum_keyan);
					student_downgrade_detail.setSum_activity(sum_activity);
					student_downgrade_detail.setSum_position(sum_position);
					student_downgrade_detail.setSum_jiangxuejin(sum_jiangxuejin);
					student_downgrade_detail.setScholar_layer_old(scholar_layer_old);
					student_downgrade_detail.setScholar_layer_new(scholar_layer_new);
					downgrade_id_detail.add(student_downgrade_detail);
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
		
			return downgrade_id_detail;
	}
		public void updatepassword(String password,String username){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql_1 = "update dengluzhanghao set password=? where id=? ";
			try {
				conn = JdbcUtil.getMySqlConnection();
				
				pstmt = conn.prepareStatement(sql_1);
				pstmt.setString(1, password);
				pstmt.setString(2, username);
				
				pstmt.executeUpdate();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
			
		}
		public List<String> upgrade_scholar_first2(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			//int first_count=Integer.parseInt(first_counter);
			List<String> upgrade_id_first=new ArrayList<String>();
			String sql="select id from tb_student where gradelayer<2 and scholar_layer_old=2 and sum_keyan>10 ";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				//pstmt.setInt(1, first_count);
				rs=pstmt.executeQuery();
				while(rs.next()){
					String id=rs.getString("id");
					upgrade_id_first.add(id);
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
		
				return upgrade_id_first;
		}
		public List<String> upgrade_scholar_second2(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			//int second_count=Integer.parseInt(second_counter);
			List<String> upgrade_id_second=new ArrayList<String>();
			String sql="select id from tb_student where gradelayer<2 and scholar_layer_old=3 and sum_keyan>10 ";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				//pstmt.setInt(1, second_count);
				rs=pstmt.executeQuery();
				while(rs.next()){
					String id=rs.getString("id");
					upgrade_id_second.add(id);
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
		
				return upgrade_id_second;
		}
		public void upgrade_scholar_first2(List<String> upgrade_id_first){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql="update tb_student set scholar_layer_new=1 where id=?";
			String sql_1="update tb_student,jiangxuejin set scholar_layer_new=jiangxuejin_rank where id=jiangxuejin.tb_student_id";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql_1);
				pstmt.executeUpdate();
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(int i=0;i<upgrade_id_first.size();i++){
				String id=upgrade_id_first.get(i);
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
					//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}	
				
			}
			
		}
		public void upgrade_scholar_second2(List<String> upgrade_id_second){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql="update tb_student set scholar_layer_new=2 where id=?";
			for(int i=0;i<upgrade_id_second.size();i++){
				String id=upgrade_id_second.get(i);
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
					//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}	
				
			}
			
			
		}
		public List<String> upgrade_scholar_first2(String first_counter){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int first_count=Integer.parseInt(first_counter);
			List<String> upgrade_id_first_must1=new ArrayList<String>();
			String sql="select id from tb_student where gradelayer=0 and scholar_layer_old=2 order by sum_jiangxuejin desc limit ? ";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, first_count);
				rs=pstmt.executeQuery();
				while(rs.next()){
					String id=rs.getString("id");
					upgrade_id_first_must1.add(id);
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
		
				return upgrade_id_first_must1;
		}
		public List<String> upgrade_scholar_second2(String second_counter){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int second_count=Integer.parseInt(second_counter);
			List<String> upgrade_id_second_must2=new ArrayList<String>();
			String sql="select id from tb_student where gradelayer=0 and scholar_layer_old=3 order by sum_jiangxuejin desc limit ? ";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, second_count);
				rs=pstmt.executeQuery();
				while(rs.next()){
					String id=rs.getString("id");
					upgrade_id_second_must2.add(id);
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
		
				return upgrade_id_second_must2;
		}
		public void upgrade_scholar_first_must1(List<String> upgrade_id_first_must1){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql="update tb_student set scholar_layer_new=1 where id=?";
			String sql_1="update tb_student,jiangxuejin set scholar_layer_new=jiangxuejin_rank where id=jiangxuejin.tb_student_id";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql_1);
				pstmt.executeUpdate();
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(int i=0;i<upgrade_id_first_must1.size();i++){
				String id=upgrade_id_first_must1.get(i);
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
					//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}	
				
			}
			
		}
		public void upgrade_scholar_second_must2(List<String> upgrade_id_second_must2){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql="update tb_student set scholar_layer_new=2 where id=?";
			for(int i=0;i<upgrade_id_second_must2.size();i++){
				String id=upgrade_id_second_must2.get(i);
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
					//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}	
				
			}
			
			
		}
		public void downgrade_scholar_first(String three_counter){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int three_count=Integer.parseInt(three_counter);
			List<String> downgrade_id_first=new ArrayList<String>();
			List<String> downgrade_id_second=new ArrayList<String>();
			String sql="select id,scholar_layer_old from tb_student  order by sum_jiangxuejin asc limit ?";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, three_count);
				rs=pstmt.executeQuery();
				while(rs.next()){
					String id=rs.getString("id");
					String scholar_layer_old=rs.getString("scholar_layer_old");
					if(scholar_layer_old.equals("1")){
					downgrade_id_first.add(id);
					}
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql_1="update tb_student set scholar_layer_new=2 where id=?";
			for(int i=0;i<downgrade_id_first.size();i++){
				String id=downgrade_id_first.get(i);
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql_1);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
					//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			downgrade_id_first.clear();
			///downgrade_id_second.clear();
			String sql_2="select id,scholar_layer_old from tb_student where gradelayer>=2 and scholar_layer_old=scholar_layer_new ";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql_2);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					String id=rs.getString("id");
					String scholar_layer_old=rs.getString("scholar_layer_old");
					//System.out.println(id);
					if(scholar_layer_old.equals("1")){
						downgrade_id_first.add(id);
						}else if(scholar_layer_old.equals("2")){
						downgrade_id_second.add(id);
						}
				}
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql_3="update tb_student set scholar_layer_new=2 where id=?";
			for(int i=0;i<downgrade_id_first.size();i++){
				String id=downgrade_id_first.get(i);
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql_3);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
					//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				String sql_4="update tb_student set scholar_layer_new=3 where id=?";
				for(int i=0;i<downgrade_id_second.size();i++){
					String id=downgrade_id_second.get(i);
					try {
						conn = JdbcUtil.getMySqlConnection();
						pstmt = conn.prepareStatement(sql_4);
						pstmt.setString(1, id);
						pstmt.executeUpdate();
						
						//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
					} catch (Exception e) {
						e.printStackTrace();
					}
			finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
			}
		
				
		}
		public void down_scholar_second(String four_counter){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int four_count=Integer.parseInt(four_counter);
			List<String> downgrade_id_second=new ArrayList<String>();
			String sql="select id from tb_student where scholar_layer_old=2 order by sum_jiangxuejin asc limit ?";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, four_count);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					String id=rs.getString("id");
					String scholar_layer_old=rs.getString("scholar_layer_old");
					downgrade_id_second.add(id);
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql_1="update tb_student set scholar_layer_new=3 where id=?";
			for(int i=0;i<downgrade_id_second.size();i++){
				String id=downgrade_id_second.get(i);
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql_1);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
					//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}	
			}
			
			
			

		}
}

package cn.itcast.web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.itcast.web.domain.ActivityDetail;
import cn.itcast.web.domain.Grade_bean;
import cn.itcast.web.domain.Position_beans;
import cn.itcast.web.domain.Student;
import cn.itcast.web.domain.StudentGrade;
import cn.itcast.web.domain.keyan;
import cn.itcast.web.util.JdbcUtil;

public class Grade {
	public List<StudentGrade> find(String username){
		List<StudentGrade> student_grade=new ArrayList<StudentGrade>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select grade.course_id,course_name,course_hour,course_credit,course_character,score,layer from grade,course where grade.course_id=course.course_id and grade.tb_student_id=? order by course_character";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			rs = pstmt.executeQuery();
			while(rs.next()){
				StudentGrade studentgrade=new StudentGrade();
				String course_id=rs.getString("grade.course_id");
				String course_name=rs.getString("course_name");
				String course_hour=rs.getString("course_hour");
				String course_credit=rs.getString("course_credit");
				String course_character=rs.getString("course_character");
				String score=rs.getString("score");
				String layer=rs.getString("layer");
				studentgrade.setCourse_id(course_id);
				studentgrade.setCourse_name(course_name);
				studentgrade.setCourse_hour(course_hour);
				studentgrade.setCourse_credit(course_credit);
				studentgrade.setCourse_character(course_character);
				studentgrade.setScore(score);
				studentgrade.setLayer(layer);
				student_grade.add(studentgrade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}	
		 return student_grade;
	}
	public Map<String,String> submit_grade(String[] ids){
		Connection conn = null;
		Map<String,String> map=new HashMap<String,String>();
		for(String id:ids){
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select course_id,course_character from course where  course_id=?";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1,id);
				rs = pstmt.executeQuery();
				while(rs.next()){
					String course_id=rs.getString("course_id");
					String course_character=rs.getString("course_character");
					map.put(course_id, course_character);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			
		 }finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				//JdbcUtil.close(conn);
			}	
			
		}
		JdbcUtil.close(conn);
		return map;
	}
	public void insert_character(Map<String,String> map,String username){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql_1 = "update grade set flag=0 where tb_student_id=? ";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql_1);
			pstmt.setString(1,username);
			pstmt.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String sql = "update grade set flag=1 where tb_student_id=? and course_id=?";
		for(Map.Entry<String ,String> entry : map.entrySet()){  
			 String course_id=entry.getKey();
			 try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,username);
					pstmt.setString(2,course_id);
					pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}		
		}
	}
	public List<Grade_bean> insert_grade_bean(String username){
		List<Grade_bean> sclist=new ArrayList<Grade_bean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select score,course_credit,layer from grade,course where grade.course_id=course.course_id and tb_student_id=? and flag=1 and course_character not like'רҵѡ�޿�'";
		
			
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,username);
				
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					Grade_bean gradebean=new Grade_bean();
					int score=Integer.parseInt(rs.getString("score"));
					double credit=Double.parseDouble(rs.getString("course_credit"));
					//System.out.println(credit);
					String clevel=rs.getString("layer");
					gradebean.setGrade(score);
					gradebean.setCredit(credit);
					gradebean.setLayer(clevel);
					sclist.add(gradebean);
					
					
				}
				
				//System.out.println(sclist.get(3).getGrade()+"---"+sclist.get(3).getCredit()+"---"+sclist.get(3).getLayer());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
		
	return sclist;
		
	}
	public void update_tb_student_id(String username,double avg_1,int counter_4){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update tb_student set coursegrade=?,gradelayer=? where id=?";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(3,username);
			pstmt.setDouble(1,avg_1);
			pstmt.setInt(2,counter_4);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}	
	}
	public void insert_keyan(String username,String[] paperName1,String[] paperName2,String[] paperType1,String[] paperType2){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql_1="delete from keyan where tb_student_id=?";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql_1);
				pstmt.setString(1,username);
				pstmt.executeUpdate();	
			} catch (Exception e) {
				e.printStackTrace();
			}
		String sql = "insert into keyan(tb_student_id,keyantype,qikanname,papertitle,paperauthor)values(?,?,?,?,?)";
		for(int i=0;i<paperName1.length;i++){
			String str_1=paperType1[i];
			String str_2=paperName1[i];
			String str_3=paperName2[i];
			String str_4=paperType2[i];
			
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,username);
				pstmt.setString(2,str_1);
				pstmt.setString(3,str_2);
				pstmt.setString(4,str_3);
				pstmt.setString(5,str_4);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
		}
	
	
	}
	public void insert_keyan_student(String username,double sum_keyan){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update tb_student set sum_keyan=? where id=?";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setDouble(1,sum_keyan);
				pstmt.setString(2,username);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}		
	}
		public void insert_huodong (String username,String[] activityType,String[] activitylayer,String[] activitydetail){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql_1="delete from activity where tb_student_id=?";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql_1);
				pstmt.setString(1,username);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "insert into activity(tb_student_id,activitytype,activitylayer,activitydetail)values(?,?,?,?)";
			for(int i=0;i<activityType.length;i++){
				String str_1=activityType[i];
				String str_2=activitylayer[i];
				String str_3=activitydetail[i];
				
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,username);
					pstmt.setString(2,str_1);
					pstmt.setString(3,str_2);
					pstmt.setString(4,str_3);
					pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}	
			}
		
	}
		public void update_student_huodong(String username,double sum_activity){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "update tb_student set sum_activity=? where id=?";
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setDouble(1,sum_activity);
					pstmt.setString(2,username);
					pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}		
		}
		public void insert_positiontable(String username,String[] positionType,String[] positionDetail){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql_1="delete from positiontable where tb_student_id=?";
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql_1);
				pstmt.setString(1,username);
				pstmt.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "insert into positiontable(tb_student_id,positiontype,positiondetail)values(?,?,?)";
			for(int i=0;i<positionType.length;i++){
				String str_1=positionType[i];	
				String str_2=positionDetail[i];	
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,username);
					pstmt.setString(2,str_1);
					pstmt.setString(3,str_2);
					pstmt.executeUpdate();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}	
			}
		
		}
		public void update_student_position(String username,double sum_position){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "update tb_student set sum_position=? where id=?";
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setDouble(1,sum_position);
					pstmt.setString(2,username);
					pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}		
			
		}
		public void insert_tb_student(String username,String[] xx_counter){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "update tb_student set xianxue_counter=? where id=?";
			for(int i=0;i<xx_counter.length;i++){
				double str_1=Double.parseDouble(xx_counter[i]);
				//System.out.println(str_1);
				str_1=str_1*10;
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setDouble(1,str_1);
					pstmt.setString(2,username);
					
					pstmt.executeUpdate();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}	
			}
		
		}
		public List<keyan> getKeyan(String username){
			List<keyan> keyanlist=new ArrayList<keyan>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select keyantype,qikanname,papertitle from keyan where tb_student_id=?";
			
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,username);
					keyan keyandetail=new keyan();
					rs=pstmt.executeQuery();
					while(rs.next()){
						String keyantype=rs.getString("keyantype");
						String qikanname=rs.getString("qikanname");
						String papertitle=rs.getString("papertitle");
						keyandetail.setKeyantype(keyantype);
						keyandetail.setQikanname(qikanname);
						keyandetail.setPapertitle(papertitle);
						keyanlist.add(keyandetail);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}	
				return keyanlist;

		}
		public List<ActivityDetail> getActivity(String username){
			List<ActivityDetail> activitylist=new ArrayList<ActivityDetail>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select activitytype,activitylayer,activitydetail from activity where tb_student_id=?";
			
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,username);
					ActivityDetail activitydetail=new ActivityDetail();
					rs=pstmt.executeQuery();
					while(rs.next()){
						String activitytype=rs.getString("activitytype");
						String activitylayer=rs.getString("activitylayer");
						String activitytitle=rs.getString("activitydetail");
						activitydetail.setActivitytype(activitytype);
						activitydetail.setActivitylayer(activitylayer);
						activitydetail.setActivitydetail(activitytitle);
						activitylist.add(activitydetail);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}	
				return activitylist;
		}
		public List<Position_beans> getPosition(String username){
			List<Position_beans> positionlist=new ArrayList<Position_beans>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select positiontype,positiondetail from positiontable where tb_student_id=?";
			Position_beans positionbeans=new Position_beans();
				try {
					conn = JdbcUtil.getMySqlConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,username);
					rs=pstmt.executeQuery();
					while(rs.next()){
						String psttype=rs.getString("positiontype");
						String pstdetail=rs.getString("positionDetail");
						positionbeans.setPositiontype(psttype);
						positionbeans.setPositiondetail(pstdetail);
						positionlist.add(positionbeans);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JdbcUtil.close(rs);
					JdbcUtil.close(pstmt);
					JdbcUtil.close(conn);
				}	
				return positionlist;
		}
		public List<StudentGrade> getCourse(String username){
			List<StudentGrade> gradelist=new ArrayList<StudentGrade>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select course.course_id,course_name,course_hour,course_credit,course_character,score,layer from grade,course where course.course_id=grade.course_id and tb_student_id=? and flag=1";
			
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,username);
				rs=pstmt.executeQuery();
				while(rs.next()){
					StudentGrade grade_student=new StudentGrade();
					String course_id=rs.getString("course.course_id");
					String course_name=rs.getString("course_name");
					String course_hour=rs.getString("course_hour");
					String course_credit=rs.getString("course_credit");
					String course_character=rs.getString("course_character");
					String score=rs.getString("score");
					String layer=rs.getString("layer");
					grade_student.setCourse_id(course_id);
					grade_student.setCourse_name(course_name);
					grade_student.setCourse_hour(course_hour);
					grade_student.setCourse_credit(course_credit);
					grade_student.setCourse_character(course_character);
					grade_student.setScore(score);
					grade_student.setLayer(layer);
					gradelist.add(grade_student);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
			return gradelist;
			
			
			
		}
		public double get_xianxue(String username){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select xianxue_counter from tb_student where id=?";
			double xianxue_counter=0;
			try {
				conn = JdbcUtil.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,username);
				rs=pstmt.executeQuery();
				if(rs.next()){
					 xianxue_counter=rs.getDouble("xianxue_counter");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}	
			return xianxue_counter;
		}
		
	
}

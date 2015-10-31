package cn.itcast.web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.web.domain.Student;
import cn.itcast.web.util.JdbcUtil;

public class Denglu {
	public boolean find(String username,String password){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dengluzhanghao where id=? and password=?";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return flag;
	}
	public List<Student> find(String username){
		List<Student> liststudent=new ArrayList<Student>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tb_student where id=? ";
		try {
			conn = JdbcUtil.getMySqlConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Student studentinfo=new Student();
				String id=rs.getString("id");
				String name=rs.getString("name");
				String sex=rs.getString("sex");
				java.sql.Date birthday=rs.getDate("birthday");
				String major=rs.getString("major");
				String guideTeacher=rs.getString("guide_teacher");
				studentinfo.setId(id);
				studentinfo.setName(name);
				studentinfo.setSex(sex);
				studentinfo.setBirthday(birthday);
				studentinfo.setMajor(major);
				studentinfo.setGuide_teacher(guideTeacher);
				liststudent.add(studentinfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}	
		 return liststudent;
	}
	

}

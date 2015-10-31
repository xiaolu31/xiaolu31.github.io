package cn.itcast.web.domain;

public class StudentGrade {
	private String course_id;
	private String course_name;
	private String course_hour;
	private String course_credit;
	private String course_character;
	private String score;
	private String layer;
	public StudentGrade(){	
	}	
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String courseId) {
		course_id = courseId;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String courseName) {
		course_name = courseName;
	}
	public String getCourse_hour() {
		return course_hour;
	}
	public void setCourse_hour(String courseHour) {
		course_hour = courseHour;
	}
	public String getCourse_credit() {
		return course_credit;
	}
	public void setCourse_credit(String courseCredit) {
		course_credit = courseCredit;
	}
	public String getCourse_character() {
		return course_character;
	}
	public void setCourse_character(String courseCharacter) {
		course_character = courseCharacter;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}
	

}

package cn.itcast.web.domain;

public class Student {
	private String id;
	private String name;
	private String sex;
	private java.util.Date birthday;
	private String major;
	private String guide_teacher;
	private double coursegrade;
	private double gradelayer;
	private double xianxue_counter;
	private double sum_keyan;
	private double sum_activity;
	private double sum_position;
	private double sum_jiangxuejin;
	private String scholar_layer;
	private String  scholar_layer_old;
	private String scholar_layer_new;
	public String getScholar_layer_old() {
		return scholar_layer_old;
	}
	public void setScholar_layer_old(String scholarLayerOld) {
		scholar_layer_old = scholarLayerOld;
	}
	public String getScholar_layer_new() {
		return scholar_layer_new;
	}
	public void setScholar_layer_new(String scholarLayerNew) {
		scholar_layer_new = scholarLayerNew;
	}
	public String getScholar_layer() {
		return scholar_layer;
	}
	public void setScholar_layer(String scholarLayer) {
		scholar_layer = scholarLayer;
	}
	public double getCoursegrade() {
		return coursegrade;
	}
	public void setCoursegrade(double coursegrade) {
		this.coursegrade = coursegrade;
	}
	public double getGradelayer() {
		return gradelayer;
	}
	public void setGradelayer(double gradelayer) {
		this.gradelayer = gradelayer;
	}
	public double getXianxue_counter() {
		return xianxue_counter;
	}
	public void setXianxue_counter(double xianxueCounter) {
		xianxue_counter = xianxueCounter;
	}
	public double getSum_keyan() {
		return sum_keyan;
	}
	public void setSum_keyan(double sumKeyan) {
		sum_keyan = sumKeyan;
	}
	public double getSum_activity() {
		return sum_activity;
	}
	public void setSum_activity(double sumActivity) {
		sum_activity = sumActivity;
	}
	public double getSum_position() {
		return sum_position;
	}
	public void setSum_position(double sumPosition) {
		sum_position = sumPosition;
	}
	public double getSum_jiangxuejin() {
		return sum_jiangxuejin;
	}
	public void setSum_jiangxuejin(double sumJiangxuejin) {
		sum_jiangxuejin = sumJiangxuejin;
	}
	public Student(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGuide_teacher() {
		return guide_teacher;
	}
	public void setGuide_teacher(String guideTeacher) {
		guide_teacher = guideTeacher;
	}

}

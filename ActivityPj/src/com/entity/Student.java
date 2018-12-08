package com.entity;

public class Student {
	private String stuid;
	private String stuname;
	private String college;
	private String specialty;
	private String counselor;
	private String xuefen;
	public String getXuefen() {
		return xuefen;
	}
	public void setXuefen(String xuefen) {
		this.xuefen = xuefen;
	}
	private String acttype;
	public String getActtype() {
		return acttype;
	}
	public void setActtype(String acttype) {
		this.acttype = acttype;
	}
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getCounselor() {
		return counselor;
	}
	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", stuname=" + stuname + ", college=" + college + ", specialty=" + specialty
				+ ", counselor=" + counselor + ", xuefen=" + xuefen + ", acttype=" + acttype + ", username=" + username
				+ ", password=" + password + "]";
	}
	

}

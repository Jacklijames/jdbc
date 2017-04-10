package com.yx.models;

import java.util.Date;

public class Student {

	private int StudentNum;// 学号
	private int MajorNum;// 专业号码
	private String StudentName;// 学生姓名
	private int StudentSex;// 性别
	private Date StudentBirthday;// 生日
	private String StudentPassword;// 密码

	public int getStudentNum() {
		return StudentNum;
	}

	public void setStudentNum(int studentNum) {
		StudentNum = studentNum;
	}

	public int getMajorNum() {
		return MajorNum;
	}

	public void setMajorNum(int majorNum) {
		MajorNum = majorNum;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public int getStudentSex() {
		return StudentSex;
	}

	public void setStudentSex(int studentSex) {
		StudentSex = studentSex;
	}

	public Date getStudentBirthday() {
		return StudentBirthday;
	}

	public void setStudentBirthday(Date studentBirthday) {
		StudentBirthday = studentBirthday;
	}

	public String getStudentPassword() {
		return StudentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		StudentPassword = studentPassword;
	}

	@Override
	public String toString() {
		return "Student [StudentNum=" + StudentNum + ", MajorNum=" + MajorNum
				+ ", StudentName=" + StudentName + ", StudentSex=" + StudentSex
				+ ", StudentBirthday=" + StudentBirthday + ", StudentPassword="
				+ StudentPassword + "]";
	}

	
}

package com.yx.models;

import java.util.Date;

public class Teacher {

	private int TeacherNum;// 教工号
	private int DeptNum;// 院系号码
	private String TeacherName;// 教师姓名
	private int TeacherSex;// 教师性别
	private Date TeacherBirthday;// 教师生日
	private String TeacherTitle;// 教师职称
	private String TeacherTel;// 教师联系号码

	public int getTeacherNum() {
		return TeacherNum;
	}

	public void setTeacherNum(int teacherNum) {
		TeacherNum = teacherNum;
	}

	public int getDeptNum() {
		return DeptNum;
	}

	public void setDeptNum(int deptNum) {
		DeptNum = deptNum;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public int getTeacherSex() {
		return TeacherSex;
	}

	public void setTeacherSex(int teacherSex) {
		TeacherSex = teacherSex;
	}

	public Date getTeacherBirthday() {
		return TeacherBirthday;
	}

	public void setTeacherBirthday(Date teacherBirthday) {
		TeacherBirthday = teacherBirthday;
	}

	public String getTeacherTitle() {
		return TeacherTitle;
	}

	public void setTeacherTitle(String teacherTitle) {
		TeacherTitle = teacherTitle;
	}

	public String getTeacherTel() {
		return TeacherTel;
	}

	public void setTeacherTel(String teacherTel) {
		TeacherTel = teacherTel;
	}

	@Override
	public String toString() {
		return "Teacher [TeacherNum=" + TeacherNum + ", DeptNum=" + DeptNum
				+ ", TeacherName=" + TeacherName + ", TeacherSex=" + TeacherSex
				+ ", TeacherBirthday=" + TeacherBirthday + ", TeacherTitle="
				+ TeacherTitle + ", TeacherTel=" + TeacherTel + "]";
	}

	
}

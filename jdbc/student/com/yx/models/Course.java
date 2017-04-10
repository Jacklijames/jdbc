package com.yx.models;

public class Course {

	private int CourseId;// 课程ID
	private String CourseName;// 课程名称
	private int CourseCredit;// 学分
	private int CourseCalss;// 学时

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public int getCourseCredit() {
		return CourseCredit;
	}

	public void setCourseCredit(int courseCredit) {
		CourseCredit = courseCredit;
	}

	public int getCourseCalss() {
		return CourseCalss;
	}

	public void setCourseCalss(int courseCalss) {
		CourseCalss = courseCalss;
	}

	@Override
	public String toString() {
		return "Course [CourseId=" + CourseId + ", CourseName=" + CourseName
				+ ", CourseCredit=" + CourseCredit + ", CourseCalss="
				+ CourseCalss + "]";
	}

	
	
}

package com.yx.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.yx.action.CourseAction;
import com.yx.models.Course;

public class CourseService {

	CourseAction ca = null;
	
	public void addCourse(Course course) throws SQLException{
		ca = new CourseAction();
		ca.addCourse(course);
	}
	
	public void deleteCourse(Course course) throws SQLException{
		ca = new CourseAction();
		ca.deleteCourse(course);
	}
	
	public void updateCourse(Course course) throws SQLException{
		ca = new CourseAction();
		ca.updateCourse(course);
	}
	
	public Course findCourse(int CourseId) throws SQLException{
		ca = new CourseAction();
		return ca.findCourse(CourseId);
	}
	
	public List<Course> findAll() throws SQLException{
		ca = new CourseAction();
		return ca.findAll();
	}
	
}

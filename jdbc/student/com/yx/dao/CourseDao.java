package com.yx.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.yx.models.Course;

public interface CourseDao {

	public void addCourse(Course course) throws SQLException;
	public void deleteCourse(Course course) throws SQLException;
	public void updateCourse(Course course) throws SQLException;
	public Course findCourse(int CourseId) throws SQLException;
	public List<Course>findAll() throws SQLException;
	
}

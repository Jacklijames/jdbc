package com.yx.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.yx.models.Teacher;

public interface TeacherDao {

	public void addTeacher(Teacher teacher) throws SQLException;
	public void deleteTeacher(Teacher teacher) throws SQLException;
	public void updateTeacher(Teacher teacher) throws SQLException;
	public Teacher findTeacher(int TeacherNum) throws SQLException;
	public List<Teacher> findAll() throws SQLException;
	
}

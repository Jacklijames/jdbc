package com.yx.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.yx.action.TeacherAction;
import com.yx.models.Teacher;

public class TeacherService {

	TeacherAction ta = null;
	
	public void addTeacher(Teacher teacher) throws SQLException{
		ta = new TeacherAction();
		ta.addTeacher(teacher);
	}
	
	public void deleteTeacher(Teacher teacher) throws SQLException{
		ta = new TeacherAction();
		ta.deleteTeacher(teacher);
	}
	
	public void updateTeacher(Teacher teacher) throws SQLException{
		ta = new TeacherAction();
		ta.updateTeacher(teacher);
	}
	
	public Teacher findTeacher(int TeacherNum) throws SQLException{
		ta = new TeacherAction();
		return ta.findTeacher(TeacherNum);
	}
	
	public List<Teacher> findAll() throws SQLException{
		ta = new TeacherAction();
		return ta.findAll();
	}
	
}

package com.yx.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.yx.action.StudentAction;
import com.yx.models.Student;

public class StudentService {

	StudentAction sa = null;
	
	public void addStudent(Student student) throws SQLException{
	
		sa =  new StudentAction();
		sa.addStudent(student);
		
	}
	
	public void deleteStudent(Student student) throws SQLException{
		sa =  new StudentAction();
		sa.deleteStudent(student);
		
	}
	
	public void updateStudent(Student student) throws SQLException{
		sa =  new StudentAction();
		sa.updateStudent(student);
		
	}
	
	public Student findStudent(int StudentNum) throws SQLException{
		sa =  new StudentAction();
		return sa.findStudent(StudentNum);
	}
	
	public List<Student>findAll() throws SQLException{
		sa = new StudentAction();
		return sa.findAll();
	}
	
	
}

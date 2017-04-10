package com.yx.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.yx.models.Student;

public interface StudentDao {

	public void addStudent(Student student) throws SQLException;
	public void deleteStudent(Student student) throws SQLException;
	public void updateStudent(Student student) throws SQLException;
	public Student findStudent(int StudentNum) throws SQLException;
	public List<Student> findAll() throws SQLException;
	
}

package com.yx.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.yx.models.College;

public interface CollegeDao {

	public void addDept(College dept) throws SQLException;
	public void deleteDept(College dept) throws SQLException;
	public void updateDept(College dept) throws SQLException;
	public College findDept(int DeptNum) throws SQLException;
	public List<College>findAll() throws SQLException;
	
}

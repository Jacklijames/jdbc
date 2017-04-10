package com.yx.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.yx.action.CollegeAction;
import com.yx.models.College;

public class CollegeService {

	CollegeAction ca = null;
	
	public void addDept(College dept) throws SQLException{
		ca = new CollegeAction();
		ca.addDept(dept);
	}
	
	public void deleteDept(College dept) throws SQLException{
		ca = new CollegeAction();
		ca.deleteDept(dept);
	}
	
	public void updateDept(College dept) throws SQLException{
		ca = new CollegeAction();
		ca.updateDept(dept);
	}
	
	public College findCollege(int DeptNum) throws SQLException{
		ca = new CollegeAction();
		return ca.findDept(DeptNum);
	}
	
	public List<College> findAll() throws SQLException{
		ca = new CollegeAction();
		return ca.findAll();
	}
}

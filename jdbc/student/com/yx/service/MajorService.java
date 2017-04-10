package com.yx.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.yx.action.MajorAction;
import com.yx.models.Major;

public class MajorService {

	MajorAction ma = null;
	
	public void addMajor(Major major) throws SQLException{
		ma = new MajorAction();
		ma.addMajor(major);
	}
	
	public void deleteMajor(Major major) throws SQLException{
		ma = new MajorAction();
		ma.deleteMajor(major);
	}
	
	public void updateMajor(Major major) throws SQLException{
		ma = new MajorAction();
		ma.updateMajor(major);
	}
	
	public Major findMajor(int MajorNum) throws SQLException{
		ma = new MajorAction();
		return ma.findMajor(MajorNum);
	}
	
	public List<Major> findAll() throws SQLException{
		ma = new MajorAction();
		return ma.findAll();
	}
}

package com.yx.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.yx.models.Major;

public interface MajorDao {

	public void addMajor(Major major) throws SQLException;
	public void deleteMajor(Major major) throws SQLException;
	public void updateMajor(Major major) throws SQLException;
	public Major findMajor(int MajorNum) throws SQLException;
	public List<Major>findAll() throws SQLException;
}

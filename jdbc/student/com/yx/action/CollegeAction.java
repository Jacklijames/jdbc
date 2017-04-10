package com.yx.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yx.dao.CollegeDao;
import com.yx.models.College;
import com.yx.models.Jdbc;

public class CollegeAction implements CollegeDao{

	public void addDept(College dept) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "insert into college (DeptNum,DeptName,DeptChairman,DeptTel) values "
				+ "(?,?,?,?);";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, dept.getDeptNum());
		ptmt.setString(2, dept.getDeptName());
		ptmt.setString(3, dept.getDeptChairman());
		ptmt.setString(4, dept.getDeptTel());
		ptmt.execute();
		
		
	}

	public void deleteDept(College dept) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "delete from college where DeptNum =?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, dept.getDeptNum());
		ptmt.execute();
		
	}

	public void updateDept(College dept) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "update college set DeptName=?,DeptChairman=?,DeptTel=? "
				+ "where DeptNum =?;";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, dept.getDeptName());
		ptmt.setString(2, dept.getDeptChairman());
		ptmt.setString(3, dept.getDeptTel());
		ptmt.setInt(4, dept.getDeptNum());
		ptmt.execute();
	}

	public College findDept(int DeptNum) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql="select Deptnum,DeptName,DeptChairman,DeptTel from college "
				+ "where DeptNum =?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, DeptNum);
		ptmt.execute();
		ResultSet rs = ptmt.executeQuery();
		College c = null;
		while(rs.next()){
			c = new College();
			c.setDeptNum(rs.getInt("DeptNum"));
			c.setDeptName(rs.getString("DeptName"));
			c.setDeptChairman(rs.getString("DeptChairman"));
			c.setDeptTel(rs.getString("DeptTel"));
		}
		
		return c;
	}

	public List<College> findAll() throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "select Deptnum,DeptName,DeptChairman,DeptTel from college ;";
		Statement ptmt = conn.createStatement();
		ResultSet rs = ptmt.executeQuery(sql);
		
		College c = null;
		List<College>set = new ArrayList<College>();
		while(rs.next()){
			c= new College();
			c.setDeptNum(rs.getInt("DeptNum"));
			c.setDeptName(rs.getString("DeptName"));
			c.setDeptChairman(rs.getString("DeptChairman"));
			c.setDeptTel(rs.getString("DeptTel"));
			set.add(c);
		}
		
		return set;
	}

}

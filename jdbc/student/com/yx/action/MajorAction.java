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

import com.yx.dao.MajorDao;
import com.yx.models.Jdbc;
import com.yx.models.Major;

public class MajorAction implements MajorDao{

	public void addMajor(Major major) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "insert into major (MajorNum,MajorName,MajorChairman,MajorTel,DeptNum) values"
				+ " (?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, major.getMajorNum());
		ptmt.setString(2, major.getMajorName());
		ptmt.setString(3, major.getMajorChairman());
		ptmt.setString(4, major.getMajorTel());
		ptmt.setInt(5, major.getDeptNum());
		ptmt.execute();
		
		
	}

	public void deleteMajor(Major major) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		String sql = "delete from major where MajorNum=?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, major.getMajorNum());
		ptmt.execute();
		
	}

	public void updateMajor(Major major) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "update major set MajorName=?,MajorChairman=?,MajorTel=?,DeptNum=?"
				+ " where MajorNum =?";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, major.getMajorName());
		ptmt.setString(2, major.getMajorChairman());
		ptmt.setString(3, major.getMajorTel());
		ptmt.setInt(4, major.getDeptNum());
		ptmt.execute();
		
	}

	public Major findMajor(int MajorNum) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql ="select MajorNum,MajorName,MajorChairman,MajorTel,DeptNum from "
				+ "major where MajorNum =?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, MajorNum);
		ResultSet rs = ptmt.executeQuery();
		
		Major m = null;
		while(rs.next()){
			m = new Major();
			m.setMajorNum(rs.getInt("MajorNum"));
			m.setMajorName(rs.getString("MajorName"));
			m.setMajorChairman(rs.getString("MajorChairman"));
			m.setMajorTel(rs.getString("MajorTel"));
			m.setDeptNum(rs.getInt("DeptNum"));
			
		}
		
		return m;
	}

	public List<Major> findAll() throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "select MajorNum,MajorName,MajorChairman,MajorTel,DeptNum from major;";
		
		Statement ptmt = conn.createStatement();
		ResultSet rs = ptmt.executeQuery(sql);
		
		Major n = null;
		List<Major>set = new ArrayList<Major>();
		while(rs.next()){
			n = new Major();
			n.setMajorNum(rs.getInt("MajorNum"));
			n.setMajorName(rs.getString("MajorName"));
			n.setMajorChairman(rs.getString("MajorChairman"));
			n.setMajorTel(rs.getString("MajorTel"));
			n.setDeptNum(rs.getInt("DeptNum"));
			set.add(n);
		}
		
		return set;
	}

}

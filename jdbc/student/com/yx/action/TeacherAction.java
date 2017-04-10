package com.yx.action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yx.dao.TeacherDao;
import com.yx.models.Jdbc;
import com.yx.models.Student;
import com.yx.models.Teacher;

public class TeacherAction implements TeacherDao{

	public void addTeacher(Teacher teacher) throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "insert into teacher (TeacherNum,DeptNum,TeacherName,TeacherSex,"
				+ "TeacherBirthday,TeacherTitle,TeacherTel) "
				+ "values (?,?,?,?,?,?,?);";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, teacher.getTeacherNum());
		ptmt.setInt(2, teacher.getDeptNum());
		ptmt.setString(3, teacher.getTeacherName());
		ptmt.setInt(4, teacher.getTeacherSex());
		ptmt.setDate(5, new Date(teacher.getTeacherBirthday().getTime()));
		ptmt.setString(6, teacher.getTeacherTitle());
		ptmt.setString(7, teacher.getTeacherTel());
		ptmt.execute();
		
		
	}

	public void deleteTeacher(Teacher teacher) throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "delete from teacher where TeacherNum = ?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, teacher.getTeacherNum());
		ptmt.execute();
		
	}

	public void updateTeacher(Teacher teacher) throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "update teacher set DeptNum=?,TeacherName=?,TeacherSex=?,TeacherBirthday=?,"
				+ "TeacherTitle=?,TeacherTel=? where TeacherNum =?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);
	
		ptmt.setInt(1, teacher.getDeptNum());
		ptmt.setString(2, teacher.getTeacherName());
		ptmt.setInt(3, teacher.getTeacherSex());
		ptmt.setDate(4, new Date(teacher.getTeacherBirthday().getTime()));
		ptmt.setString(5, teacher.getTeacherTitle());
		ptmt.setString(6, teacher.getTeacherTel());
		ptmt.setInt(7, teacher.getTeacherNum());
		ptmt.execute();
		
	}

	public Teacher findTeacher(int TeacherNum) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "select Teachernum,TeacherName,DeptNum,TeacherSex,TeacherBirthday,TeacherTitle,TeacherTel "
				+ "from teacher where TeacherNum = ?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, TeacherNum);
		ptmt.execute();
		
		Teacher s =null;
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			s = new Teacher();
			s.setTeacherNum(rs.getInt("TeacherNum"));
			s.setTeacherName(rs.getString("TeacherName"));
			s.setDeptNum(rs.getInt("DeptNum"));
			s.setTeacherSex(rs.getInt("TeacherSex"));
			s.setTeacherBirthday(rs.getDate("TeacherBirthday"));
			s.setTeacherTitle(rs.getString("TeacherTitle"));
			s.setTeacherTel(rs.getString("TeacherTel"));
			
		}
		
		
		return s;
	}

	public List<Teacher> findAll() throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "select TeacherNum,TeacherName,DeptNum,TeacherSex,TeacherBirthday,TeacherTitle,TeacherTel "
				+ "from teacher group by TeacherNum;";
		Statement ptmt = conn.createStatement();
		ResultSet rs = ptmt.executeQuery(sql);
		Teacher s = null;
		List<Teacher> set = new ArrayList<Teacher>();
		
		while(rs.next()){
			s = new Teacher();
			s.setTeacherNum(rs.getInt("TeacherNum"));
			s.setTeacherName(rs.getString("TeacherName"));
			s.setDeptNum(rs.getInt("DeptNum"));
			s.setTeacherSex(rs.getInt("TeacherSex"));
			s.setTeacherBirthday(rs.getDate("TeacherBirthday"));
			s.setTeacherTitle(rs.getString("TeacherTitle"));
			s.setTeacherTel(rs.getString("TeacherTel"));
			
			set.add(s);
		}
		
		return set;
	}

	
	
}

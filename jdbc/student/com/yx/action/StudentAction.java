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

import com.yx.models.*;

public class StudentAction implements com.yx.dao.StudentDao{

	public void addStudent(Student student) throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "insert into student (StudentNum,MajorNum,StudentName,StudentSex,"
				+ "StudentBirthday,StudentPassword) "
				+ "value (?,?,?,?,?,?);";
		PreparedStatement ptmt = conn.prepareStatement(sql);//sql语句预编译
		ptmt.setInt(1, student.getStudentNum());
		ptmt.setInt(2, student.getMajorNum());
		ptmt.setString(3, student.getStudentName());
		ptmt.setInt(4, student.getStudentSex());
		try
		{
		//把你认为可能发生异常的代码段放在这里
			ptmt.setDate(5, new Date(student.getStudentBirthday().getTime()));//检查处错误的堆栈
		}catch(NullPointerException e)
		{
		System.out.println("发生异常的原因为 :"+e.getMessage());
		}
		
		ptmt.setString(6, student.getStudentPassword());
		ptmt.execute();
		
		
	}

	public void deleteStudent(Student student) throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "delete from student where StudentNum = ?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, student.getStudentNum());
		ptmt.execute();
		
	}

	public void updateStudent(Student student) throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "update student set MajorNum=?,StudentName=?,StudentSex=?,StudentBirthday=?,"
				+ "StudentPassword=? where StudentNum =?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);
	
		ptmt.setInt(1, student.getMajorNum());
		ptmt.setString(2, student.getStudentName());
		ptmt.setInt(3, student.getStudentSex());
		ptmt.setDate(4, new Date(student.getStudentBirthday().getTime()));
		ptmt.setString(5, student.getStudentPassword());
		ptmt.setInt(6, student.getStudentNum());
		ptmt.execute();
		
	}

	public Student findStudent(int StudentNum) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "select StudentNum,StudentName,MajorNum,StudentSex,StudentBirthday,StudentPassword "
				+ "from student where StudentNum = ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, StudentNum);
		ptmt.execute();
		
		Student s =null;
		ResultSet rs = ptmt.executeQuery();//数据库结果集的数据表
		while(rs.next()){
			s = new Student();
			s.setStudentNum(rs.getInt("StudentNum"));
			s.setStudentName(rs.getString("StudentName"));
			s.setMajorNum(rs.getInt("MajorNum"));
			s.setStudentSex(rs.getInt("StudentSex"));
			s.setStudentBirthday(rs.getDate("StudentBirthday"));
			s.setStudentPassword(rs.getString("StudentPassword"));
			
		}
		
		
		return s;
	}

	public List<Student> findAll() throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "select StudentNum,StudentName,MajorNum,StudentSex,StudentBirthday,StudentPassword "
				+ "from student order by StudentNum;";
		Statement ptmt = conn.createStatement();//用于执行静态 SQL 语句并返回它所生成结果的对象
		ResultSet rs = ptmt.executeQuery(sql);
		Student s = null;
		List<Student> set = new ArrayList<Student>();
		
		while(rs.next()){
			s = new Student();
			s.setStudentNum(rs.getInt("StudentNum"));
			s.setStudentName(rs.getString("StudentName"));
			s.setMajorNum(rs.getInt("MajorNum"));
			s.setStudentSex(rs.getInt("StudentSex"));
			s.setStudentBirthday(rs.getDate("StudentBirthday"));
			s.setStudentPassword(rs.getString("StudentPassword"));
			
			set.add(s);
		}
		
		return set;
	}

	
}

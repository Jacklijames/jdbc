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

import com.yx.dao.CourseDao;
import com.yx.models.Course;
import com.yx.models.Jdbc;

public class CourseAction implements CourseDao{

	public void addCourse(Course course) throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "insert into course (CourseId,CourseName,CourseCredit,CourseClass) values "
				+ "(?,?,?,?);";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, course.getCourseId());
		ptmt.setString(2, course.getCourseName());
		ptmt.setInt(3, course.getCourseCredit());
		ptmt.setInt(4, course.getCourseCalss());
		ptmt.execute();
		
	}

	public void deleteCourse(Course course) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "delete from course where CourseId=?;";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, course.getCourseId());
		ptmt.execute();
		
	}

	public void updateCourse(Course course) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "update course set CourseName = ?,CourseCredit=?,CourseClass=? where CourseId = ?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setString(1, course.getCourseName());
		ptmt.setInt(2, course.getCourseCredit());
		ptmt.setInt(3, course.getCourseCalss());
		ptmt.setInt(4, course.getCourseId());
		ptmt.execute();
		
	}

	public Course findCourse(int CourseId) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "select CourseId,CourseName,CourseCredit,CourseClass from course "
				+ "where CourseId = ?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, CourseId);
		ptmt.execute();
		
		Course c = null;
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			c = new Course();
			c.setCourseId(rs.getInt("CourseId"));
			c.setCourseName(rs.getString("CourseName"));
			c.setCourseCredit(rs.getInt("CourseCredit"));
			c.setCourseCalss(rs.getInt("CourseClass"));
			
		}
		
		
		return c;
	}

	public List<Course> findAll() throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		
		String sql = "select  CourseId,CourseName,CourseCredit,CourseClass from course;";
		Statement ptmt = conn.createStatement();
		ResultSet rs = ptmt.executeQuery(sql);
		
		Course c = null;
		List<Course> set = new ArrayList<Course>();
		while(rs.next()){
			c = new Course();
			
			c.setCourseId(rs.getInt("CourseId"));
			c.setCourseName(rs.getString("CourseName"));
			c.setCourseCredit(rs.getInt("CourseCredit"));
			c.setCourseCalss(rs.getInt("CourseClass"));
			set.add(c);
		}
		
		
		return set;
	}

}

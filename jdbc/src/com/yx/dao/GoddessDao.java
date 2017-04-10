package com.yx.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yx.jdbc.Test;
import com.yx.model.Goddess;

public class GoddessDao {

	public void addGoddess(Goddess g) throws SQLException{
		Test test = new Test();
		Connection conn = test.getConnection();
		
		String sql="" +
				"insert into imooc_goddess" +
				"(user_name,sex,age,birthday,email,mobile," +
				"create_user,create_date,update_user,update_date,isdel)" +
				"values(" +
				"?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		//sql语句预编译
		PreparedStatement ptmt=conn.prepareStatement(sql);
		//传参
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		//执行
		ptmt.execute();
	}
	
	public void updateGoddess(Goddess g) throws SQLException{
		
		Test test = new Test();
		Connection conn = test.getConnection();
		
		String sql="" +
				"update imooc_goddess set" +
				" user_name = ?,sex = ?,age = ?,birthday = ?,email = ?,mobile = ?," +
				"update_user = ?,update_date = current_date,isdel = ?" +
				" where id = ?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9, g.getId());
		ptmt.execute();
		
	}
	
	public void delGoddess(Integer id) throws SQLException{
		
		Test test = new Test();
		Connection conn = test.getConnection();
		
		String sql="" +
				"delete from imooc_goddess " +
				" where id = ?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
		
		
	}
	
	public List<Goddess> query() throws SQLException{
		
		Test test = new Test();
		Connection conn = test.getConnection();
		
		//直接执行sql语句，并获取查询数据
		 Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("select user_name,age,id from imooc_goddess");
	
         List<Goddess> gs = new ArrayList<Goddess>();
         Goddess g = null;
         //为页面显示传递参数
         while(rs.next()){
        	 g = new Goddess();
        	 g.setId(rs.getInt("id"));
        	 g.setUser_name(rs.getNString("user_name"));
        	 g.setAge(rs.getInt("age"));
        	 gs.add(g);
        	 
         	//System.out.println(rs.getNString("user_name")+ "," + rs.getInt("age"));
         }
		
		return gs;
	}
	
public List<Goddess> query(String name,String mobile,String email) throws SQLException{
		
		Test test = new Test();
		Connection conn = test.getConnection();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select * from imooc_goddess");
		sb.append(" where user_name like ? and mobile like ? and email like ?");
		
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%" + name + "%");
		ptmt.setString(2, "%" + mobile + "%");
		ptmt.setString(3, "%" + email + "%");

		System.out.println(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();
         
         List<Goddess> gs = new ArrayList<Goddess>();
         Goddess g = null;
         
         while(rs.next()){
        	 g = new Goddess();
        	 g.setId(rs.getInt("id"));
 			g.setUser_name(rs.getString("user_name"));
 			g.setAge(rs.getInt("age"));
 			g.setSex(rs.getInt("sex"));
 			g.setBirthday(rs.getDate("birthday"));
 			g.setEmail(rs.getString("email"));
 			g.setMobile(rs.getString("mobile"));
 			g.setCreate_data(rs.getDate("create_date"));
 			g.setCreate_user(rs.getString("create_user"));
 			g.setUpdate_data(rs.getDate("update_date"));
 			g.setUpdate_user(rs.getString("update_user"));
 			
 			gs.add(g);
         	//System.out.println(rs.getNString("user_name")+ "," + rs.getInt("age"));
         }
		
		return gs;
	}

public List<Goddess> query(List<Map<String,Object>> params) throws SQLException{
	
	Test test = new Test();
	Connection conn = test.getConnection();
	
	StringBuilder sb = new StringBuilder();
	sb.append("select * from imooc_goddess where 1 = 1");

	if(params != null && params.size()>0){
		for (int i = 0; i < params.size(); i++) {
			Map<String,Object> map = params.get(i);
			sb.append(" and " + map.get("name") + " " + map.get("rela") + " " + map.get("value"));
		}
	}
	
	
	PreparedStatement ptmt = conn.prepareStatement(sb.toString());

	System.out.println(sb.toString());
	
	ResultSet rs = ptmt.executeQuery();
     
     List<Goddess> result = new ArrayList<Goddess>();
     Goddess g = null;
     
     while(rs.next()){
    	 g = new Goddess();
    	 g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_data(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_data(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			
			result.add(g);
     	//System.out.println(rs.getNString("user_name")+ "," + rs.getInt("age"));
     }
	
	return result;
}
	
	public Goddess get(Integer id) throws SQLException{
		
		Goddess g = new Goddess();
		
		Test test = new Test();
		Connection conn = test.getConnection();
		
		String sql="" +
				"select * from imooc_goddess " +
				" where id = ?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		
		while (rs.next()) {
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_data(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_data(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			
		}
		return g;
	}
}

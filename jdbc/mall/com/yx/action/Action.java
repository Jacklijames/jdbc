package com.yx.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yx.jdbc.Jdbc;
import com.yx.usergoods.UserGoods;

public class Action {

	public void add(UserGoods u) throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();

		String sql = "insert into user_goods (user_name,sex,goods_id,date) value (?,?,?,current_date)";

		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, u.getUser_name());
		ptmt.setInt(2, u.getSex());
		ptmt.setInt(3, u.getGoods_id());
		ptmt.execute();
	}

	public void del(Integer id) throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();

		String sql = "delete from user_goods where ?;";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setInt(1, id);
		ptmt.execute();
	}

	public void update(UserGoods u) throws SQLException {

		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		String sql = "update user_goods set user_name =?,sex =?,goods_id =?,date =current_date where id = ? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, u.getUser_name());
		ptmt.setInt(2, u.getSex());
		ptmt.setInt(3, u.getGoods_id());
		ptmt.setInt(4, u.getId());
		ptmt.execute();
	}

	public List<UserGoods> query() throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();

		Statement ptmt = conn.createStatement();
		String sql = "select * from user_goods";
		ResultSet rs = ptmt.executeQuery(sql);
		UserGoods g = null;
		List<UserGoods> result = new ArrayList<UserGoods>();

		while (rs.next()) {
			g = new UserGoods();// 将new出的新值放在while外面就会只打印最后一个，因为在不停的赋值。必须一行一个对象，
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setSex(rs.getInt("sex"));
			g.setGoods_id(rs.getInt("goods_id"));
			g.setDate(rs.getDate("date"));

			result.add(g);
		}

		return result;

	}

	public UserGoods get(int id) throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection conn = jdbc.getConnection();
		UserGoods u = null;

		String sql = "select * from user_goods where id =?";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setInt(1, id);
		ptmt.execute();

		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			u = new UserGoods();
			u.setId(rs.getInt("id"));
			u.setUser_name(rs.getString("user_name"));
			u.setSex(rs.getInt("sex"));
			u.setGoods_id(rs.getInt("goods_id"));
			u.setDate(rs.getDate("date"));
		}
		return u;

	}

}

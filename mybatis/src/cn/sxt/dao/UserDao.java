package cn.sxt.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.sxt.entity.User;
import cn.sxt.util.MybatisUtil;

public class UserDao {

	public User getById(int id) throws IOException{
		SqlSession session = MybatisUtil.getSqlSession();
		User user = session.selectOne("cn.sxt.entity.UserMapper.selectUser",id );
		
		session.close();
		return user;
	}
	
	public List<User> getAll() throws IOException{
		SqlSession session = MybatisUtil.getSqlSession();
		List<User> list = session.selectList("cn.sxt.entity.UserMapper.selectAll");
		
		session.close();
		return list;
		
	}
	public int add(User user) throws IOException{
		SqlSession session = MybatisUtil.getSqlSession();
		int result = session.insert("cn.sxt.entity.UserMapper.addUser", user);
		session.commit();
		session.close();
		return result;
		
	}
	public int update(User user) throws IOException{
		SqlSession session = MybatisUtil.getSqlSession();
		
		int result = session.insert("cn.sxt.entity.UserMapper.updateUser", user);
		session.commit();
		session.close();
		return result;
	}
	public int delete(int id) throws IOException{
		SqlSession session = MybatisUtil.getSqlSession();
		int result = session.delete("cn.sxt.entity.UserMapper.deleteUser", id);
		session.commit();
		session.close();
		return result;
	}
}

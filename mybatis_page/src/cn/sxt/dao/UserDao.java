package cn.sxt.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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
	//分页查询,两种方法：
	public List<User> selectAll(int currentPage,int pageSize) throws IOException{
		SqlSession session = MybatisUtil.getSqlSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startIndex", (currentPage-1)*pageSize);
		map.put("pageSize", pageSize);
		List<User> list = session.selectList("cn.sxt.entity.UserMapper.selectAll",map);
		
		session.close();
		return list;
		
	}
	
	public List<User> getAll(int currentPage,int pageSize) throws IOException{
		SqlSession session = MybatisUtil.getSqlSession();
		
		RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize,pageSize);
		List<User> list = session.selectList("cn.sxt.entity.UserMapper.getAll",null,rowBounds);
		
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

package cn.sxt.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.sxt.dao.UserDao;
import cn.sxt.entity.User;
import cn.sxt.util.MybatisUtil;

public class Test {

	public static void main(String[] args) throws IOException {
	UserDao userDao = new UserDao();
	List<User> list = userDao.getAll(1,2);
	
	for (User user : list) {
		System.out.println(user.toString());
	}
//	User user = userDao.getById(3);
//	
//	user.setPwd("12345");
//	user.setName("aaa");
	
	//System.out.println(userDao.delete(4));
	
	//System.out.println(userDao.getById(1));
	}
	
}

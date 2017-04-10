package cn.sxt.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.sxt.dao.UserDao;
import cn.sxt.entity.User;
import cn.sxt.util.MybatisUtil;

public class Test {

	public static void main(String[] args) throws IOException {

		SqlSession session = MybatisUtil.getSqlSession();
		UserDao userDao = session.getMapper(UserDao.class);
		List<User> list = userDao.getList();//动态的实现了接口的实现类，故不用写实现类。
		for (User user : list) {
			System.out.println(user);
		}
		User user = new User();
		user.setName("li");
		user.setPwd("123");
		//获取sql语句也就是执行插入的语句所在类。
		UserDao  userDao2= session.getMapper(UserDao.class) ;
		userDao2.insert(user);
	}
	
}

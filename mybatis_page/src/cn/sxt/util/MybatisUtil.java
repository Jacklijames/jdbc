package cn.sxt.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	//创建SqlSessionFactory（是sqlSession的一个工厂类）以及获得sqlSession（通过id找到对应的sql语句，执行sql语句）。
	public static SqlSessionFactory getSqlSessionFactory() throws IOException{
		
		String resource = "mybatis.config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	public static SqlSession getSqlSession() throws IOException{
		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();
		return sqlSessionFactory.openSession();
	}
}

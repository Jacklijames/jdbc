package cn.sxt.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	//����SqlSessionFactory����sqlSession��һ�������ࣩ�Լ����sqlSession��ͨ��id�ҵ���Ӧ��sql��䣬ִ��sql��䣩��
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

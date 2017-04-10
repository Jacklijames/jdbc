package cn.sxt.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.sxt.entity.Student;
import cn.sxt.util.MybatisUtil;

public class StudentDao {

	

	public List<Student> getAll() throws IOException {
		SqlSession session = MybatisUtil.getSqlSession();
		List<Student> list = session
				.selectList("cn.sxt.entity.student.mapper.getStudents");

		session.close();
		return list;

	}

	

	
}

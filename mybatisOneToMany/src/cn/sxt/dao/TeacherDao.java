package cn.sxt.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.sxt.entity.Student;
import cn.sxt.entity.Teacher;
import cn.sxt.util.MybatisUtil;

public class TeacherDao {

	public Teacher getTeacher(int id) throws IOException {
		SqlSession session = MybatisUtil.getSqlSession();
		Teacher teacher = session
				.selectOne("cn.sxt.entity.teacher.mapper.getTeacher",id);

		session.close();
		return teacher;

	}
	
}

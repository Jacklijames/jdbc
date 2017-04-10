package cn.sxt.test;

import java.io.IOException;
import java.util.List;

import cn.sxt.dao.StudentDao;
import cn.sxt.dao.TeacherDao;
import cn.sxt.entity.Student;
import cn.sxt.entity.Teacher;

public class Test {

	public static void main(String[] args) throws IOException {
//		StudentDao studentDao = new StudentDao();
//		List<Student> list = studentDao.getAll();
//		for (Student student : list) {
//			System.out.println("student name = " + student.getName() + "  teacher name=" + student.getTeacher().getName());
//		}
		
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.getTeacher(1);
		System.out.println("teacher name = " + teacher.getName());
		List<Student> student = teacher.getStudent();
		for (Student stu : student) {
			System.out.println("student name = "+stu.getName());
		}
		
	}

}

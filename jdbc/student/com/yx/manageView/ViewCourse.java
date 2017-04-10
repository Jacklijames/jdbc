package com.yx.manageView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.yx.models.Course;
import com.yx.service.CourseService;

public class ViewCourse {

	Scanner scan = new Scanner(System.in);

	public void viewCourse() {
		System.out
		.println("请选择您要进行的操作：\n [add]添加课程信息\n [delete]删除课程信息 \n [update]修改课程信息\n "
				+ "[findCourse]查看课程详细信息\n [findAll]查看所有课程\n [exit]返回上一层");

Course course = new Course();
CourseService cs = new CourseService();
int step = 1;
String record = null;

while (scan.hasNext()) {
	String in = scan.next().toString();
	if (in.equalsIgnoreCase("exit")) {
		System.out.println("您已返回主界面！");
		return;

	}
	else if (in.equalsIgnoreCase("add") || "add".equalsIgnoreCase(record)) {
		record = "add";
		if (step == 1) {
			System.out.println("请输入你要添加的课程ID");
		}
		if (step == 2) {
			course.setCourseId(Integer.valueOf(in));
			System.out.println("请输入你要添加的课程名称");
		}
		if (step == 3) {
			course.setCourseName(in);
			System.out.println("请输入你要添加的课程学分");
		}
		if (step == 4) {
			course.setCourseCredit(Integer.valueOf(in));
			System.out.println("请输入你要添加的课程学时");
		}
		if (step == 5) {
			course.setCourseCalss(Integer.valueOf(in));

			try {
				cs.addCourse(course);
				System.out.println("添加成功");
			} catch (SQLException e) {
				System.out.println("添加失败");
				e.printStackTrace();
			}
		}
		if (record.equalsIgnoreCase("add")) {
			step++;
		}
		if (step == 6) {
			step = 1;
		}

	}
	else if (in.equalsIgnoreCase("delete")
			|| "delete".equalsIgnoreCase(record)) {
		record = "delete";
		if (step == 1) {
			System.out.println("请输入你要删除的课程ID");
		}
		if (step == 2) {
			course.setCourseId(Integer.valueOf(in));
			try {
				cs.deleteCourse(course);
				System.out.println("删除成功");
			} catch (SQLException e) {
				System.out.println("删除失败");
				e.printStackTrace();
			}
		}
		if (record.equalsIgnoreCase("delete")) {
			step++;
		}
		if (step == 3) {
			step = 1;
		}

	}
	else if (in.equalsIgnoreCase("update")
			|| "update".equalsIgnoreCase(record)) {

		record = "update";
		if (step == 1) {
			System.out.println("请输入你要修改的课程ID");
		}
		if (step == 2) {
			course.setCourseId(Integer.valueOf(in));
			System.out.println("请输入你要修改的课程名称");
		}
		if (step == 3) {
			course.setCourseName(in);
			System.out.println("请输入你要修改的课程学分");
		}
		if (step == 4) {
			course.setCourseCredit(Integer.valueOf(in));
			System.out.println("请输入你要修改的课程学时");
		}
		if (step == 5) {
			course.setCourseCalss(Integer.valueOf(in));

			try {
				cs.updateCourse(course);
				System.out.println("修改成功");
			} catch (SQLException e) {
				System.out.println("修改失败");
				e.printStackTrace();
			}
		}
		if (record.equalsIgnoreCase("update")) {
			step++;
		}
		if (step == 6) {
			step = 1;

		}

	}
	else if (in.equalsIgnoreCase("findCourse")
			|| "findCourse".equalsIgnoreCase(record)) {
		record = "findCourse";
		if (step == 1) {
			System.out.println("请输入你要查询的课程ID");
		}
		if (step == 2) {
			course.setCourseId(Integer.valueOf(in));
			try {
				Course c = cs.findCourse(course.getCourseId());
				System.out.println(c.toString());
			} catch (SQLException e) {
				System.out.println("查询失败");
				e.printStackTrace();
			}
		}
		if (record.equalsIgnoreCase("findCourse")) {
			step++;
		}
		if (step == 3) {
			step = 1;
		}

	}
	else if (in.equalsIgnoreCase("findAll")) {
		List<Course> set = new ArrayList<Course>();
		try {
			set = cs.findAll();
			for (Course c : set) {
				System.out.println(c.getCourseId() + " "
						+ c.getCourseName());
			}
		} catch (SQLException e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
	}else{
		System.out.println("请重新输入命令");
	}
}

}

}

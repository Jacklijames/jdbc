package com.yx.manageView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yx.models.Course;
import com.yx.service.CourseService;

public class ViewTestCourse {

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
			
			switch(in){
			case "exit": {
				System.out.println("您已返回主界面！");
				System.out
				.println("欢迎使用岳晓管理系统！\n 您可以进行以下操作：\n [student]对在校学生信息进行操作 ；\n [teacher]对在校教师进行操作；\n"
						+ " [course]对学校所开课程进行操作 \n [major]对学校所开系别进行操作\n [college]对学校所开学院进行操作\n [exit]退出系统");
				return;

			} 
			case "add": {
				record = "add";
				
				System.out.println("请输入你要添加的课程ID");
				while(in.equalsIgnoreCase("add")||scan.hasNext()){
					
					String inn = scan.next().toString();
					if("add".equalsIgnoreCase(record)){
						
						
						if (step == 1) {
							course.setCourseId(Integer.valueOf(inn));
							System.out.println("请输入你要添加的课程名称");
						}
						if (step == 2) {
							course.setCourseName(inn);
							System.out.println("请输入你要添加的课程学分");
						}
						if (step == 3) {
							course.setCourseCredit(Integer.valueOf(inn));
							System.out.println("请输入你要添加的课程学时");
						}
						if (step == 4) {
							course.setCourseCalss(Integer.valueOf(inn));

							try {
								cs.addCourse(course);
								System.out.println("添加成功");
							} catch (SQLException e) {
								System.out.println("添加失败");
								//e.printStackTrace();
							}
						}
						if (record.equalsIgnoreCase("add")) {
							step++;
						}
						if (step == 5) {
							step = 1;
							break;
						}
					}
				}
				
				break;
			} 
			case"delete": {
				record = "delete";
				
				System.out.println("请输入你要删除的课程ID");
				while(in.equalsIgnoreCase("delete")||scan.hasNext()){

					String inn = scan.next().toString();
					if("delete".equalsIgnoreCase(record)){
						
						
						if (step == 1) {
							course.setCourseId(Integer.valueOf(inn));
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
						if (step == 2) {
							step = 1;
							break;
						}
					}
					
				}
				
				break;
			} case "update": {

				record = "update";
				
				System.out.println("请输入你要修改的课程ID");
				while(in.equalsIgnoreCase("update")||scan.hasNext()){

					String inn = scan.next().toString();
					if("update".equalsIgnoreCase(record)){
						
						
						if (step == 1) {
							course.setCourseId(Integer.valueOf(inn));
							System.out.println("请输入你要修改的课程名称");
						}
						if (step == 2) {
							course.setCourseName(inn);
							System.out.println("请输入你要修改的课程学分");
						}
						if (step == 3) {
							course.setCourseCredit(Integer.valueOf(inn));
							System.out.println("请输入你要修改的课程学时");
						}
						if (step == 4) {
							course.setCourseCalss(Integer.valueOf(inn));

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
						if (step == 5) {
							step = 1;
							break;
						}
					}
					
				}
				
				break;
			} 
			case"findCourse":{
				record = "findCourse";
				

				System.out.println("请输入你要查询的课程ID");
				while(in.equalsIgnoreCase("findCourse")||scan.hasNext()){
					
					String inn = scan.next().toString();
					if("findCourse".equalsIgnoreCase(record)){
						
						
						if (step == 1) {
							course.setCourseId(Integer.valueOf(inn));
							try {
								Course c = cs.findCourse(course.getCourseId());
								System.out.println(c.toString());
							} catch (SQLException e) {
								System.out.println("查询失败");
								//e.printStackTrace();
							}
						}
						if (record.equalsIgnoreCase("findCourse")) {
							step++;
						}
						if (step == 2) {
							step = 1;
							break;
						}
						
					}
				}
				
				break;
			} 
			case "findAll": {
				List<Course> set = new ArrayList<Course>();
				try {
					set = cs.findAll();
					for (Course c : set) {
						System.out.println(c.getCourseId() + " "
								+ c.getCourseName());
					}
				} catch (SQLException e) {
					System.out.println("查询失败");
					//e.printStackTrace();
				}
				break;
			} default: {
				System.out.println("请重新输入命令");
				break;
			}
			}
			
		}

	}
}

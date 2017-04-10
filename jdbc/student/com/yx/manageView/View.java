package com.yx.manageView;

import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		// 主界面
		System.out
				.println("欢迎使用岳晓管理系统！\n 您可以进行以下操作：\n [student]对在校学生信息进行操作 ；\n [teacher]对在校教师进行操作；\n"
						+ " [course]对学校所开课程进行操作 \n [major]对学校所开系别进行操作\n [college]对学校所开学院进行操作\n [exit]退出系统");
		ViewStudent vb = new ViewStudent();
		ViewTeacher vt = new ViewTeacher();
		ViewCourse vc = new ViewCourse();
		ViewMajor vm = new ViewMajor();
		ViewCollege vco = new ViewCollege();
		
		
		ViewTestTeacher teacher = new ViewTestTeacher();
		
		ViewTest vtt = new ViewTest();
		ViewTestCourse course = new ViewTestCourse();
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			String in = scan.next().toString();
			if (in.equalsIgnoreCase("student")) {
				//vb.viewStudent();
				vtt.viewStudent();
			} else if (in.equalsIgnoreCase("teacher")) {
				//vt.viewTeacher();
				teacher.viewTeacher();
			} else if (in.equalsIgnoreCase("course")) {
				//vc.viewCourse();
				course.viewCourse();
			} else if (in.equalsIgnoreCase("major")) {
				vm.viewMajor();
			} else if (in.equalsIgnoreCase("college")) {
				vco.viewCollege();
			}else if(in.equalsIgnoreCase("exit")){
				break;
			}else{
				System.out.println("请重新输入");
			}
		}

	}

}

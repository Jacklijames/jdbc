package com.yx.manageView;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.yx.models.Teacher;
import com.yx.service.TeacherService;

public class ViewTeacher {
	Scanner scan = new Scanner(System.in);

	public void viewTeacher() {
		System.out
				.println("请选择您要进行的操作：\n [add]添加教师信息\n [delete]删除教师信息 \n [update]修改教师信息\n "
						+ "[findTeacher]查看教师详细信息\n [findAll]查看所有教师\n [exit]返回上一层");
		Teacher teacher = new Teacher();
		TeacherService tt = new TeacherService();// 此变量不放在外边则一直显示为空；
		int step = 1;// 控制步数
		int del = 1;
		String record = null;// 实现步数增长

		while (scan.hasNext()) {
			String in = scan.next().toString();
			if (in.equalsIgnoreCase("exit")) {
				System.out.println("您已返回主界面");
				return;
			}
			else if (in.equalsIgnoreCase("add") || "add".equalsIgnoreCase(record)) {
				record = "add";
				if (step == 1) {
					System.out.println("请输入你要添加的教师教工号");
				}
				if (step == 2) {
					teacher.setTeacherNum(Integer.valueOf(in));
					System.out.println("请输入你要添加教师的姓名");
				}
				if (step == 3) {
					teacher.setTeacherName(in);
					System.out.println("请输入你要添加的教师所在学院");
				}
				if (step == 4) {
					teacher.setDeptNum(Integer.valueOf(in));
					System.out.println("请输入你要添加的教师性别");
				}
				if (step == 5) {
					teacher.setTeacherSex(Integer.valueOf(in));
					System.out.println("请输入你要添加的教师生日,格式如“yyyy-MM-dd”");
				}
				if (step == 6) {
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
					Date birthday;
					try {
						birthday = sf.parse(in);
						teacher.setTeacherBirthday(birthday);
						System.out.println("请输入教师职称");
					} catch (ParseException e) {
						System.out.println("输入格式有误，请重新输入");
						e.printStackTrace();
						step = 5;
					}

				}
				if (step == 7) {
					teacher.setTeacherTitle(in);
					System.out.println("请输入·教师联系方式");
				}
				if (step == 8) {
					teacher.setTeacherTel(in);
					try {
						tt.addTeacher(teacher);
						System.out.println("添加成功");
					} catch (SQLException e) {
						System.out.println("添加失败");
						e.printStackTrace();
					}
				}
				if (record.equalsIgnoreCase("add")) {
					step++;
				}
				if (step == 9) {
					step = 1;

				}
			}
			else if (in.equalsIgnoreCase("delete")
					|| "delete".equalsIgnoreCase(record)) {
				record = "delete";
				if (step == 1) {
					System.out.println("请输入你要删除教师的教工号");
				}
				if (step == 2) {
					teacher.setTeacherNum(Integer.valueOf(in));
					try {

						tt.deleteTeacher(teacher);
						System.out.println("删除成功");
					} catch (SQLException e) {
						System.out.println("删除成功");
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
					System.out.println("请输入你要修改的教师教工号");
				}
				if (step == 2) {
					teacher.setTeacherNum(Integer.valueOf(in));
					System.out.println("请输入你要修改教师的姓名");
				}
				if (step == 3) {
					teacher.setTeacherName(in);
					System.out.println("请输入你要修改的教师所在学院");
				}
				if (step == 4) {
					teacher.setDeptNum(Integer.valueOf(in));
					System.out.println("请输入你要修改的教师性别");
				}
				if (step == 5) {
					teacher.setTeacherSex(Integer.valueOf(in));
					System.out.println("请输入你要修改的教师生日,格式如“yyyy-MM-dd”");
				}
				if (step == 6) {
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
					Date birthday;
					try {
						birthday = sf.parse(in);
						teacher.setTeacherBirthday(birthday);
						System.out.println("请输入教师职称");
					} catch (ParseException e) {
						System.out.println("输入格式有误，请重新输入");
						e.printStackTrace();
						step = 5;
					}

				}
				if (step == 7) {
					teacher.setTeacherTitle(in);
					System.out.println("请输入教师联系方式");
				}
				if (step == 8) {
					teacher.setTeacherTel(in);
					try {
						tt.updateTeacher(teacher);
						System.out.println("修改成功");
					} catch (SQLException e) {
						System.out.println("修改失败");
						e.printStackTrace();
					}
				}
				if (record.equalsIgnoreCase("update")) {
					step++;
				}
				while (step == 9) {
					step = 1;
				}

			}
			else if (in.equalsIgnoreCase("findteacher")
					|| "findteacher".equalsIgnoreCase(record)) {
				record = "findteacher";
				if (step == 1) {
					System.out.println("请输入你要查询教师的教工号");
				}
				if (step == 2) {
					teacher.setTeacherNum(Integer.valueOf(in));
					try {
						Teacher t = tt.findTeacher(teacher.getTeacherNum());
						System.out.println(t.toString());
					} catch (SQLException e) {
						System.out.println("查询失败");
						e.printStackTrace();
					}
				}
				if (record.equalsIgnoreCase("findteacher")) {
					step++;
				}
				if (step == 3) {
					step = 1;
				}
			}
			else if (in.equalsIgnoreCase("findAll")) {
				List<Teacher> set = new ArrayList<Teacher>();
				try {
					set = tt.findAll();
					for (Teacher t : set) {
						System.out.println(t.getTeacherNum() + " "
								+ t.getTeacherName());
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

package com.yx.manageView;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.yx.models.Teacher;
import com.yx.service.TeacherService;

public class ViewTestTeacher {


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
			
			switch(in){
			case "exit":{
				System.out.println("您已返回主界面");
				System.out
				.println("欢迎使用岳晓管理系统！\n 您可以进行以下操作：\n [student]对在校学生信息进行操作 ；\n [teacher]对在校教师进行操作；\n"
						+ " [course]对学校所开课程进行操作 \n [major]对学校所开系别进行操作\n [college]对学校所开学院进行操作\n [exit]退出系统");
				return;
			}
			case "add":{
				record = "add";
				System.out.println("请输入你要添加的教师教工号");
				while(in.equalsIgnoreCase("add")||scan.hasNext()){
					String inn = scan.next().toString();
					if("add".equalsIgnoreCase(record)){

						if (step == 1) {
							teacher.setTeacherNum(Integer.valueOf(inn));
							System.out.println("请输入你要添加教师的姓名");
						}
						if (step == 2) {
							teacher.setTeacherName(inn);
							System.out.println("请输入你要添加的教师所在学院");
						}
						if (step == 3) {
							teacher.setDeptNum(Integer.valueOf(inn));
							System.out.println("请输入你要添加的教师性别");
						}
						if (step == 4) {
							if(inn.equalsIgnoreCase("1")||inn.equalsIgnoreCase("0")){
								teacher.setTeacherSex(Integer.valueOf(inn));
								System.out.println("请输入你要添加的教师生日,格式如“yyyy-MM-dd”");
							}else{
								System.out.println("输入格式有误，请重新输入：");
								step =3;
							}
							
						}
						if (step == 5) {
							SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
							Date birthday;
							try {
								birthday = sf.parse(inn);
								teacher.setTeacherBirthday(birthday);
								System.out.println("请输入教师职称");
							} catch (ParseException e) {
								System.out.println("输入格式有误，请重新输入");
								//e.printStackTrace();
								step = 4;
							}

						}
						if (step == 6) {
							teacher.setTeacherTitle(inn);
							System.out.println("请输入·教师联系方式");
						}
						if (step == 7) {
							teacher.setTeacherTel(inn);
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
						if (step == 8) {
							step = 1;
							break;
						}
						
					}
					
					
				}
				break;
			}
			case"delete": {
				record = "delete";
				
				System.out.println("请输入你要删除教师的教工号");
				while(in.equalsIgnoreCase("delete")||scan.hasNext()){
					String inn = scan.next().toString();
					if("delete".equalsIgnoreCase(record)){
						
						
						if (step == 1) {
							teacher.setTeacherNum(Integer.valueOf(inn));
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
						if (step == 2) {
							step = 1;
							break;
						}
						
					}
				}
				
				break;
			}
			case "update": {

				record = "update";
				

				System.out.println("请输入你要修改的教师教工号");
				while(in.equalsIgnoreCase("update")||scan.hasNext()){
					
					String inn = scan.next().toString();
					if("update".equalsIgnoreCase(record)){
						
						
						if (step == 1) {
							teacher.setTeacherNum(Integer.valueOf(inn));
							System.out.println("请输入你要修改教师的姓名");
						}
						if (step == 2) {
							teacher.setTeacherName(inn);
							System.out.println("请输入你要修改的教师所在学院");
						}
						if (step == 3) {
							teacher.setDeptNum(Integer.valueOf(inn));
							System.out.println("请输入你要修改的教师性别,0是女，1是男：");
						}
						if (step == 4) {
							teacher.setTeacherSex(Integer.valueOf(inn));
							System.out.println("请输入你要修改的教师生日,格式如“yyyy-MM-dd”");
						}
						if (step == 5) {
							SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
							Date birthday;
							try {
								birthday = sf.parse(inn);
								teacher.setTeacherBirthday(birthday);
								System.out.println("请输入教师职称");
							} catch (ParseException e) {
								System.out.println("输入格式有误，请重新输入");
								e.printStackTrace();
								step = 4;
							}

						}
						if (step == 6) {
							teacher.setTeacherTitle(inn);
							System.out.println("请输入教师联系方式");
						}
						if (step == 7) {
							teacher.setTeacherTel(inn);
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
						while (step == 8) {
							step = 1;
							break;
						}
						
					}
				}
				
				break;
			}
			case "findTeacher": {
				record = "findTeacher";
				

				System.out.println("请输入你要查询教师的教工号");
				while(in.equalsIgnoreCase("findTeacher")||scan.hasNext()){
					

					String inn = scan.next().toString();
					if("findTeacher".equalsIgnoreCase(record)){
						
						if (step == 1) {
							teacher.setTeacherNum(Integer.valueOf(inn));
							try {
								Teacher t = tt.findTeacher(teacher.getTeacherNum());
								System.out.println(t.toString());
							} catch (SQLException e) {
								System.out.println("查询失败");
								//e.printStackTrace();
							}
						}
						if (record.equalsIgnoreCase("findTeacher")) {
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
				List<Teacher> set = new ArrayList<Teacher>();
				try {
					set = tt.findAll();
					for (Teacher t : set) {
						System.out.println(t.getTeacherNum() + " "
								+ t.getTeacherName());
					}

				} catch (SQLException e) {
					System.out.println("查询失败");
					//e.printStackTrace();
				}
				break;
			}default:{
				System.out.println("请重新输入命令");
				break;
			}
			}
			
		}
	}


}

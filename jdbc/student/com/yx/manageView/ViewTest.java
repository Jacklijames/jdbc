package com.yx.manageView;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.yx.models.Student;
import com.yx.service.StudentService;

public class ViewTest {


	Scanner scan = new Scanner(System.in);

	// 操作学生
	public void viewStudent() {
		System.out
				.println("请选择您要进行的操作：\n [add]添加学生信息\n [delete]删除学生信息 \n [update]修改学生信息\n "
						+ "[findStudent]查看学生详细信息\n [findAll]查看所有学生\n [exit]返回上一层");
		Student student = new Student();
		StudentService ss = new StudentService();// 此变量不放在外边则一直显示为空；
		
		String record = null;// 实现步数增长


		int step = 1;// 控制步数
		int del = 1;
		
		
		while (scan.hasNext()) {
			
			String in = scan.next().toString();
			
			switch(in){
			
			case "exit": {
				System.out.println("您已返回主界面");
				System.out
				.println("欢迎使用岳晓管理系统！\n 您可以进行以下操作：\n [student]对在校学生信息进行操作 ；\n [teacher]对在校教师进行操作；\n"
						+ " [course]对学校所开课程进行操作 \n [major]对学校所开系别进行操作\n [college]对学校所开学院进行操作\n [exit]退出系统");
				return;
				
			}
			
			
			case "add": {
				record = "add";
				System.out.println("请输入添加学生的学号：");
				while(in.equalsIgnoreCase("add")||scan.hasNext()){
					
					String inn = scan.next().toString();
					if("add".equalsIgnoreCase(record)){
						
						
						if (step == 1) {
							student.setStudentNum(Integer.valueOf(inn));
							System.out.println("请输入添加学生的姓名：");
							
						}
						if (step == 2) {
							student.setStudentName(inn);
							System.out.println("请输入添加学生的性别 0是女； 1是男：");
						}
						if (step == 3) {
							if(inn.equalsIgnoreCase("1")||inn.equalsIgnoreCase("0")){
								student.setStudentSex(Integer.valueOf(inn));
								System.out.println("请输入添加学生的系别：");
							}else{
								System.out.println("输入有误，请重新输入：");
								step =2;
							}
							
						}
						if (step == 4) {
							student.setMajorNum(Integer.valueOf(inn));
							System.out.println("请输入添加学生的生日,格式如“yyyy-MM-dd”");
						}
						if (step == 5) {
							SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
							Date birthday;
							try {
								birthday = sf.parse(inn);

								student.setStudentBirthday(birthday);

								System.out.println("请输入添加学生的密码！");
							} catch (ParseException e) {
								//e.printStackTrace();
								System.out.println("输入格式有误，请重新输入！");
								step = 4;
							}

						}
						if (step == 6) {
							student.setStudentPassword(inn);
							try {
								ss.addStudent(student);
								System.out.println("添加成功！");
							} catch (SQLException e) {
								e.printStackTrace();
								System.out.println("添加失败！");
							}
						}
						if (record.equalsIgnoreCase("add")) {
							step++;
						}
						 if (step == 7) {
							step = 1;
							break;
						}
					}
				
					
				}
				break;
			
			}
			case "delete": {
				record = "delete";
				System.out.println("请输入你要删除信息的学生学号：");
				while(in.equalsIgnoreCase("delete")||scan.hasNext()){
					
					String inn = scan.next().toString();
				
					if("delete".equalsIgnoreCase(record)){
						
						
						 if (del == 1) {
							student.setStudentNum(Integer.valueOf(inn));
							
							try {
								ss.deleteStudent(student);
								System.out.println("删除成功！");
							} catch (SQLException e) {
								System.out.println("删除失败！");
								e.printStackTrace();
							}
							
						}
						if (record.equalsIgnoreCase("delete")) {
							del++;
						}
						 if (del == 2) {
							del = 1;
							break;
						}
					}
				}
			
				
				break;
			}
			case "update": {
				record = "update";
				System.out.println("请输入你要修改信息的学生学号：");
				while(in.equalsIgnoreCase("update")||scan.hasNext()){
					
					String inn = scan.next().toString();
					
					if (step == 1) {
						student.setStudentNum(Integer.valueOf(inn));
						System.out.println("请输入你要修改的姓名");
					}
					if (step == 2) {
						student.setStudentName(inn);
						System.out.println("请输入你要修改的性别 0是女； 1是男");
						
					}
					if (step == 3) {
						if(inn.equalsIgnoreCase("0")||inn.equalsIgnoreCase("1")){
							student.setStudentSex(Integer.valueOf(inn));
							System.out.println("请输入你要修改的生日,格式如“yyyy-MM-dd”");
						}else{
							System.out.println("输入格式有误，请重新输入");
							step =2;
						}
					
					}
					if (step == 4) {
						SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
						Date birthday;
						try {
							birthday = sf.parse(inn);
							student.setStudentBirthday(birthday);
							System.out.println("请输入你要修改的密码");
						} catch (ParseException e) {
							System.out.println("输入格式有误，请重新输入！");
							//e.printStackTrace();
							step = 3;

						}

					}
					if (step == 5) {
						student.setStudentPassword(inn);
						try {
							ss.updateStudent(student);
							System.out.println("更新成功");
						} catch (SQLException e) {
							e.printStackTrace();
							System.out.println("更新失败");
						}
					}
					if (record.equalsIgnoreCase("update")) {
						step++;
					}
					 if (step == 6) {
						step = 1;
						break;
					}
				}
			
				
			break;
			}
			case "findStudent":{
				record = "findStudent";
				System.out.println("请输入你要查询信息的学生学号：");
				while(in.equalsIgnoreCase("update")||scan.hasNext()){
					
					
					String inn = scan.next().toString();
					
					if (step == 1) {

						student.setStudentNum(Integer.valueOf(inn));
						try {
							Student s = ss.findStudent(student.getStudentNum());
							System.out.println(s.toString());
						} catch (SQLException e) {
							System.out.println("查询失败");
							e.printStackTrace();
						}

					}
					if (record.equalsIgnoreCase("findStudent")) {
						step++;
					}
					 if (step == 2) {
						step = 1;
						break;
					    }
				}
				
			break;
			}
			case "findAll": {
				List<Student> set = new ArrayList<Student>();
				try {
					set = ss.findAll();
					for (Student s : set) {
						System.out.println(s.getStudentNum() + " "
								+ s.getStudentName());
						
					}
				} catch (SQLException e) {
					//e.printStackTrace();
					System.out.println("查询失败");
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

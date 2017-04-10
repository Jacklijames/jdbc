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

import com.yx.models.Student;
import com.yx.service.StudentService;

public class ViewStudent {

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
			

				if (in.equalsIgnoreCase("exit")) {
					System.out.println("您已返回主界面");
					return;
				}
				
				
				else if (in.equalsIgnoreCase("add")
						|| "add".equalsIgnoreCase(record)) {
					record = "add";
				
					if (step == 1) {
						System.out.println("请输入添加学生的学号：");
					}
					if (step == 2) {
						student.setStudentNum(Integer.valueOf(in));
						System.out.println("请输入添加学生的姓名：");
					}
					if (step == 3) {
						student.setStudentName(in);
						System.out.println("请输入添加学生的性别 0是女； 1是男：");
					}
					if (step == 4) {
						student.setStudentSex(Integer.valueOf(in));
						System.out.println("请输入添加学生的系别：");
					}
					if (step == 5) {
						student.setMajorNum(Integer.valueOf(in));
						System.out.println("请输入添加学生的生日,格式如“yyyy-MM-dd”");
					}
					if (step == 6) {
						SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
						Date birthday;
						try {
							birthday = sf.parse(in);

							student.setStudentBirthday(birthday);

							System.out.println("请输入添加学生的密码！");
						} catch (ParseException e) {
							e.printStackTrace();
							System.out.println("输入格式有误，请重新输入！");
							step = 5;
						}

					}
					if (step == 7) {
						student.setStudentPassword(in);
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
					 if (step == 8) {
						step = 1;
						
					}
				
				}
				else if (in.equalsIgnoreCase("delete")
						|| "delete".equalsIgnoreCase(record)) {
					record = "delete";
				
					if (del == 1) {
						System.out.println("请输入你要删除信息的学生学号：");
					}
					if (del == 2) {
						student.setStudentNum(Integer.valueOf(in));
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
					 if (del == 3) {
						del = 1;
						
					}
					
				}
				else if (in.equalsIgnoreCase("update")
						|| "update".equalsIgnoreCase(record)) {
					record = "update";
				
					if (step == 1) {
						System.out.println("请输入你要修改信息的学生学号：");
					}
					if (step == 2) {
						student.setStudentNum(Integer.valueOf(in));
						System.out.println("请输入你要修改的姓名");
					}
					if (step == 3) {
						student.setStudentName(in);
						System.out.println("请输入你要修改的性别 0是女； 1是男");
					}
					if (step == 4) {
						student.setStudentSex(Integer.valueOf(in));
						System.out.println("请输入你要修改的生日,格式如“yyyy-MM-dd”");
					}
					if (step == 5) {
						SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
						Date birthday;
						try {
							birthday = sf.parse(in);
							student.setStudentBirthday(birthday);
							System.out.println("请输入你要修改的密码");
						} catch (ParseException e) {
							System.out.println("输入格式有误，请重新输入！");
							e.printStackTrace();
							step = 4;

						}

					}
					if (step == 6) {
						student.setStudentPassword(in);
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
					 if (step == 7) {
						step = 1;
						
					}
					
				}
				else if (in.equalsIgnoreCase("findStudent")
						|| "findStudent".equalsIgnoreCase(record)) {
					record = "findStudent";
					
					if (step == 1) {
						System.out.println("请输入你要查询的学生学号");
					}
					if (step == 2) {

						student.setStudentNum(Integer.valueOf(in));
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
					 if (step == 3) {
						step = 1;
						
  				    }
					
				}
				else if (in.equalsIgnoreCase("findAll")) {
					List<Student> set = new ArrayList<Student>();
					try {
						set = ss.findAll();
						for (Student s : set) {
							System.out.println(s.getStudentNum() + " "
									+ s.getStudentName());
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("查询失败");
					}
					

				}else{
					System.out.println("请重新输入命令");
				}

			}
		}
	
}

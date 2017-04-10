package com.yx.manageView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.yx.models.College;
import com.yx.service.CollegeService;

public class ViewCollege {

	Scanner scan = new Scanner(System.in);

	public void viewCollege() {
		System.out
				.println("请选择您要进行的操作：\n [add]添加学院信息\n [delete]删除学院信息 \n [update]修改学院信息\n "
						+ "[findCollege]查看学院详细信息\n [findAll]查看所有学院\n [exit]返回上一层");

		College college = new College();
		CollegeService cs = new CollegeService();
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
					System.out.println("请输入你要添加的学院ID");
				}
				if (step == 2) {
					college.setDeptNum(Integer.valueOf(in));
					System.out.println("请输入你要添加的学院名");
				}
				if (step == 3) {
					college.setDeptName(in);
					System.out.println("请输入你要添加的学院主任");
				}
				if (step == 4) {
					college.setDeptChairman(in);
					System.out.println("请输入你要添加的学院联系方式");
				}
				if (step == 5) {
					college.setDeptTel(in);

					try {
						cs.addDept(college);
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
					System.out.println("请输入你要删除的学院ID");
				} else if (step == 2) {
					college.setDeptNum(Integer.valueOf(in));
					try {
						cs.deleteDept(college);
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
					System.out.println("请输入你要修改的学院ID");
				}
				if (step == 2) {
					college.setDeptNum(Integer.valueOf(in));
					System.out.println("请输入你要修改的学院名");
				}
				if (step == 3) {
					college.setDeptName(in);
					System.out.println("请输入你要修改的学院主任");
				}
				if (step == 4) {
					college.setDeptChairman(in);
					System.out.println("请输入你要修改的学院联系方式");
				}
				if (step == 5) {
					college.setDeptTel(in);

					try {
						cs.updateDept(college);
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
			else if (in.equalsIgnoreCase("findCollege")
					|| "findCollege".equalsIgnoreCase(record)) {
				record = "findCollege";
				if (step == 1) {
					System.out.println("请输入你要查询的学院ID");
				}
				if (step == 2) {
					college.setDeptNum(Integer.valueOf(in));
					try {
						College c = cs.findCollege(college.getDeptNum());
						System.out.println(c.toString());
					} catch (SQLException e) {
						System.out.println("查询失败");
						e.printStackTrace();
					}
				}
				if (record.equalsIgnoreCase("findCollege")) {
					step++;
				}
				if (step == 3) {
					step = 1;
				}

			}
			else if (in.equalsIgnoreCase("findAll")) {
				List<College> set = new ArrayList<College>();
				try {
					set = cs.findAll();
					for (College c : set) {
						System.out.println(c.getDeptNum() + " "
								+ c.getDeptName());
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

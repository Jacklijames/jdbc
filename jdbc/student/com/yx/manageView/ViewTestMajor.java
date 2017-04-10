package com.yx.manageView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yx.models.Major;
import com.yx.service.MajorService;

public class ViewTestMajor {
	


	Scanner scan = new Scanner(System.in);

	public void viewMajor() {
		System.out
				.println("请选择您要进行的操作：\n [add]添加系信息\n [delete]删除系信息 \n [update]修改系信息\n "
						+ "[findMajor]查看系详细信息\n [findAll]查看所有系\n [exit]返回上一层");

		Major major = new Major();
		MajorService ms = new MajorService();
		int step = 1;
		String record = null;

		while (scan.hasNext()) {
			String in = scan.next().toString();

			if (in.equalsIgnoreCase("exit")) {
				System.out.println("您已返回主界面");
				return;
			}

			else if (in.equalsIgnoreCase("add") || "add".equalsIgnoreCase(record)) {
				record = "add";
				if (step == 1) {
					System.out.println("请输入你要添加的系ID");
				}
				if (step == 2) {
					major.setMajorNum(Integer.valueOf(in));
					System.out.println("请输入你要添加的系名称");
				}
				if (step == 3) {
					major.setMajorName(in);
					System.out.println("请输入你要添加的系所在的学院");
				}
				if (step == 4) {
					major.setDeptNum(Integer.valueOf(in));
					System.out.println("请输入你要添加的系主任");
				}
				if (step == 5) {
					major.setMajorChairman(in);
					System.out.println("请输入您要添加的系联系方式");
				}
				if (step == 6) {
					major.setMajorTel(in);
					try {
						ms.addMajor(major);
						System.out.println("添加成功");
					} catch (SQLException e) {
						System.out.println("添加失败");
						e.printStackTrace();
					}
				}
				if (record.equalsIgnoreCase("add")) {
					step++;

				}
				if (step == 7) {
					step = 1;
				}

			}
			else if (in.equalsIgnoreCase("delete")
					|| "delete".equalsIgnoreCase(record)) {
				record = "delete";
				if (step == 1) {
					System.out.println("请输入你要删除的系ID");
				}
				if (step == 2) {
					major.setMajorNum(Integer.valueOf(in));
					try {
						ms.deleteMajor(major);
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
					System.out.println("请输入你要修改的系ID");
				}
				if (step == 2) {
					major.setMajorNum(Integer.valueOf(in));
					System.out.println("请输入你要修改的系名称");
				}
				if (step == 3) {
					major.setMajorName(in);
					System.out.println("请输入你要修改的系所在的学院");
				}
				if (step == 4) {
					major.setDeptNum(Integer.valueOf(in));
					System.out.println("请输入你要修改的系主任");
				}
				if (step == 5) {
					major.setMajorChairman(in);
					System.out.println("请输入您要修改的系联系方式");
				}
				if (step == 6) {
					major.setMajorTel(in);
					try {
						ms.updateMajor(major);
						System.out.println("修改成功");
					} catch (SQLException e) {
						System.out.println("修改失败");
						e.printStackTrace();
					}
				}
				if (record.equalsIgnoreCase("update")) {
					step++;

				}
				if (step == 7) {
					step = 1;
				}
			}
			else if (in.equalsIgnoreCase("findMajor")
					|| "findMajor".equalsIgnoreCase(record)) {
				record = "findMajor";
				if (step == 1) {
					System.out.println("请输入你要查询的系ID");
				}
				if (step == 2) {
					major.setMajorNum(Integer.valueOf(in));
					try {
						Major m = ms.findMajor(major.getMajorNum());
						System.out.println(m.toString());
					} catch (SQLException e) {
						System.out.println("查询失败");
						e.printStackTrace();
					}
				}
				if (record.equalsIgnoreCase("findMajor")) {
					step++;
				}
				if (step == 3) {
					step = 1;
				}

			}
			else if (in.equalsIgnoreCase("findAll")) {
				List<Major> set = new ArrayList<Major>();
				try {
					set = ms.findAll();
					for (Major m : set) {
						System.out.println(m.getMajorNum() + " "
								+ m.getMajorName());
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

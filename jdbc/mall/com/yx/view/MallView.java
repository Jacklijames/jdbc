package com.yx.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yx.action.Action;
import com.yx.usergoods.UserGoods;

public class MallView {

	public static void main(String[] args) {

		String home_page = "欢迎使用购物查询系统！\n" + "[add] : 增加购物信息 \n"
				+ "[delete] : 删除购物信息\n" + "[update] : 修改购物信息\n"
				+ "[query] : 查询全部购物信息\n" + "[get] : 获取顾客详细购物信息\n"
				+ "[exit] : 退出查询系统";

		System.out.println(home_page);

		UserGoods usergoods = new UserGoods();
		Action action = new Action();
		int del = 1;
		String record = null;
		int ad = 1;
		int up = 1;

		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNext()) {
			String in = scan.next().toString();

			if (in.equalsIgnoreCase("exit")) {
				System.out.println("成功退出");
				break;
			} else if (in.equalsIgnoreCase("delete")
					|| "delete".equalsIgnoreCase(record)) {
				record = "delete";
				if (del == 1) {
					System.out.println("请选择你要删除信息的客户ID");
				} else if (del == 2) {
					try {
						action.del(Integer.valueOf(in));
						System.out.println("成功删除");
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if ("delete".equalsIgnoreCase(record)) {
					del++;
				}
				while (del >2 ){
					del =1;
				}

			} else if (in.equalsIgnoreCase("add")
					|| "add".equalsIgnoreCase(record)) {
				record = "add";

				if (ad == 1) {
					System.out.println("请输入你要添加信息的客户名");
				} else if (ad == 2) {
					usergoods.setUser_name(in);
					System.out.println("请输入你要添加信息的客户性别；1是女；2是男；3是保密");
				} else if (ad == 3) {
					usergoods.setSex(Integer.valueOf(in));//输入3，在数据库中变为了2；
					System.out.println("请输入你所添加客户购买商品的ID");
				} else if (ad == 4) {
					usergoods.setGoods_id(Integer.valueOf(in));
					try {
						action.add(usergoods);
						System.out.println("添加成功");
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("添加失败");
					}

				}
				if (record.equalsIgnoreCase("add")) {
					ad++;
				}
				while (ad >4) {
					ad = 1;
				}
			} else if (in.equalsIgnoreCase("update")
					|| "update".equalsIgnoreCase(record)) {
				record = "update";
				if (up == 1) {
					System.out.println("请输入你要修改信息的客户ID");
				} else if (up == 2) {
					usergoods.setId(Integer.valueOf(in));
					System.out.println("请输入你要修改信息的客户名");
				} else if (up == 3) {
					usergoods.setUser_name(in);
					System.out.println("请输入你要修改信息的客户性别；1是女；2是男；3是保密");
				} else if (up == 4) {
					usergoods.setSex(Integer.valueOf(in));
					System.out.println("请输入你要修改客户购买商品的ID");
				} else if (up == 5) {
					usergoods.setGoods_id(Integer.valueOf(in));

					try {
						action.update(usergoods);
						System.out.println("修改成功");
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("修改失败");
					}
				}
				if (record.equalsIgnoreCase("update")) {
					up++;
				}
				while(up >5){
					up =1;
				}
			} else if (in.equalsIgnoreCase("query")) {

				try {
					List<UserGoods> list = new ArrayList<UserGoods>();

					list = action.query();

					for (int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i).getId() + " "
								+ list.get(i).getUser_name());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (in.equalsIgnoreCase("get")
					|| "get".equalsIgnoreCase(record)) {
				record = "get";
				if (ad == 1) {
					System.out.println("请输入你要查询客户的ID");
				} else if (ad == 2) {
					try {

						UserGoods u = action.get(Integer.valueOf(in));
						System.out.println(u);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (record.equalsIgnoreCase("get")) {
					ad++;
				}
				while (ad >2){
					ad =1;
				}
			}
		}
	}

}

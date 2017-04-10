package com.yx.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.yx.goddess.GoddessAction;
import com.yx.model.Goddess;

public class View {

	private static final String CONTEXT = "欢迎来到女神禁区：\n" + "下面是女神禁区的功能列表：\n"
			+ "[MAIN/M]:主菜单\n" + "[QUERY/Q]:查看全部女神的信息\n"
			+ "[GET/G]:查看某位女神的详细信息\n" + "[ADD/A]:添加女神信息\n"
			+ "[UPDATE/U]:更新女神信息\n" + "[DELETE/D]:删除女神信息\n"
			+ "[SEARCH/S]:查询女神信息(根据姓名、手机号来查询)\n" + "[EXIT/E]:退出女神禁区\n"
			+ "[BREAK/B]:退出当前功能，返回主菜单";

	private static final String OPERATION_MAIN = "MAIN";
	private static final String OPERATION_QUERY = "QUERY";
	private static final String OPERATION_GET = "GET";
	private static final String OPERATION_ADD = "ADD";
	private static final String OPERATION_UPDATE = "UPDATE";
	private static final String OPERATION_DELETE = "DELETE";
	private static final String OPERATION_SEARCH = "SEARCH";
	private static final String OPERATION_EXIT = "EXIT";
	private static final String OPERATION_BREAK = "BREAK";

	public static void main(String[] args) {
		System.out.println(CONTEXT);

		Scanner scan = new Scanner(System.in);

		Goddess goddess = new Goddess();
		GoddessAction action = new GoddessAction();
		String prenious = null;
		Integer step = 1;
		int up = 1;
		int de = 1;
		int ge = 1;
		int qu = 1;

		while (scan.hasNext()) {

			String in = scan.next().toString();

			if (OPERATION_EXIT.equals(in.toUpperCase())
					|| OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())) {
				System.out.println("您已成功退出");
				break;
			} else if (OPERATION_QUERY.equals(in.toUpperCase())
					|| OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())) {

				try {
					List<Goddess> list = action.query();
					for (Goddess go : list) {
						System.out.println(go.getId() + ",姓名 :"
								+ go.getUser_name());
						;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else if (OPERATION_SEARCH.equals(in.toUpperCase())
					|| OPERATION_SEARCH.substring(0, 1).equals(in.toUpperCase())) {
				List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("name", "user_name");
				map.put("rela", "=");
				map.put("value", "'小夏'");
				
				params.add(map);
				
				List<Goddess> result = null;
				try {
					result = action.query(params);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0; i < result.size(); i++) {
					System.out.println(result.get(i).getId() + ":" + result.get(i).getUser_name());
				
			    }

			} else if (OPERATION_DELETE.equals(in.toUpperCase())
					|| OPERATION_DELETE.substring(0, 1)
							.equals(in.toUpperCase())
					|| OPERATION_DELETE.equals(prenious)) {
				prenious = OPERATION_DELETE;

				if (de == 1) {
					System.out.println("请输入你要删除女神的ID");

				} else if (2 == de) {
					try {
						action.del(Integer.valueOf(in));
						System.out.println("删除成功");
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				if (OPERATION_DELETE.equals(prenious)) {
					de++;
				}
			} else if (OPERATION_GET.equals(in.toUpperCase())
					|| OPERATION_GET.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_GET.equals(prenious)) {

				prenious = OPERATION_GET;

				if (ge == 1) {
					System.out.println("请输入你要查看女神的ID");

				} else if (2 == ge) {
					try {
						Goddess go = action.get(Integer.valueOf(in));
						System.out.println(go);
						System.out.println("查找成功");
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				if (OPERATION_GET.equals(prenious)) {
					ge++;
				}

			}

			else if (OPERATION_UPDATE.equals(in.toUpperCase())
					|| OPERATION_UPDATE.substring(0, 1)
							.equals(in.toUpperCase())
					|| OPERATION_UPDATE.equals(prenious)) {

				prenious = OPERATION_UPDATE;
				if (up == 1) {
					System.out.println("请输入女神的【姓名】");
				} else if (2 == up) {

					goddess.setUser_name(in);
					System.out.println("请输入女神的【年龄】");
				} else if (3 == up) {
					goddess.setAge(Integer.valueOf(in));
					System.out.println("请输入女神的【生日】,格式如yyyy-mm-dd");

				} else if (4 == up) {
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
					Date birthday;
					try {
						birthday = sf.parse(in);
						goddess.setBirthday(birthday);
						System.out.println("请输入女神的【邮箱】");
					} catch (ParseException e) {
						e.printStackTrace();
						System.out.println("您输入的格式有误，请重新输入！");
						up = 3;
					}

				} else if (up == 5) {
					goddess.setEmail(in);
					System.out.println("请输入女神的【手机号】");
				} else if (up == 6) {
					goddess.setMobile(in);
					System.out.println("请输入女神的【性别】");

				} else if (up == 7) {
					goddess.setSex(Integer.valueOf(in));
					System.out.println("请输入女神的【修改人】");
				} else if (up == 8) {
					goddess.setCreate_user(in);
					System.out.println("请输入女神的【ID】");
				} else if (up == 9) {
					goddess.setId(Integer.valueOf(in));
					System.out.println("请输入女神的【号】");
				} else if (up == 10) {
					goddess.setIsdel(Integer.valueOf(in));

					try {
						action.edit(goddess);
						System.out.println("成功");
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("修改女神失败");
					}
				}

				if (OPERATION_UPDATE.equals(prenious)) {
					up++;
				}

			}

			else if (OPERATION_ADD.equals(in.toUpperCase())
					|| OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_ADD.equals(prenious)) {

				prenious = OPERATION_ADD;
				if (step == 1) {
					System.out.println("请输入女神的【姓名】");
				} else if (2 == step) {

					goddess.setUser_name(in);
					System.out.println("请输入女神的【年龄】");
				} else if (3 == step) {
					goddess.setAge(Integer.valueOf(in));
					System.out.println("请输入女神的【生日】,格式如yyyy-mm-dd");

				} else if (4 == step) {
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
					Date birthday;
					try {
						birthday = sf.parse(in);
						goddess.setBirthday(birthday);
						System.out.println("请输入女神的【邮箱】");
					} catch (ParseException e) {
						e.printStackTrace();
						System.out.println("您输入的格式有误，请重新输入！");
						step = 3;
					}

				} else if (step == 5) {
					goddess.setEmail(in);
					System.out.println("请输入女神的【手机号】");
				} else if (step == 6) {
					goddess.setMobile(in);
					System.out.println("请输入女神的【性别】");

				} else if (step == 7) {
					goddess.setSex(Integer.valueOf(in));
					System.out.println("请输入女神的【创建人】");
				} else if (step == 8) {
					goddess.setCreate_user(in);
					System.out.println("请输入女神的【创建日期】,格式如 yyyy-mm-dd");
				} else if (step == 9) {
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
					Date create_birthday;
					try {
						create_birthday = sf.parse(in);
						goddess.setCreate_data(create_birthday);
						System.out.println("请输入女神的【号】");
					} catch (ParseException e) {
						e.printStackTrace();
						System.out.println("您输入的格式有误，请重新输入！");
						step = 8;
					}
				} else if (step == 10) {
					goddess.setIsdel(Integer.valueOf(in));

					try {
						action.add(goddess);
						System.out.println("成功");
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("新增女神失败");
					}
				}

				if (OPERATION_ADD.equals(prenious)) {
					step++;
				}

			}/*
			 * else{ System.out.println("您输入的值为：" + in); }
			 */

		}

	}

}

package com.yx.usergoods;

import java.util.Date;

public class UserGoods {

	private int id;
	private String user_name;
	private int sex;
	private int goods_id;
	private Date date;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserGoods [id=" + id + ", user_name=" + user_name + ", sex="
				+ sex + ", goods_id=" + goods_id + ", date=" + date + "]";
	}

}

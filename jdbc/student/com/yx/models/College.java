package com.yx.models;

public class College {

	private int DeptNum;// 院号码
	private String DeptName;// 院名
	private String DeptChairman;// 院主任
	private String DeptTel;// 院联系方式

	public int getDeptNum() {
		return DeptNum;
	}

	public void setDeptNum(int deptNum) {
		DeptNum = deptNum;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public String getDeptChairman() {
		return DeptChairman;
	}

	public void setDeptChairman(String deptChairman) {
		DeptChairman = deptChairman;
	}

	public String getDeptTel() {
		return DeptTel;
	}

	public void setDeptTel(String deptTel) {
		DeptTel = deptTel;
	}

	@Override
	public String toString() {
		return "College [DeptNum=" + DeptNum + ", DeptName=" + DeptName
				+ ", DeptChairman=" + DeptChairman + ", DeptTel=" + DeptTel
				+ "]";
	}

	
}

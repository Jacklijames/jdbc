package com.yx.models;

public class Major {

	private int MajorNum;// 系号码
	private String MajorName;// 系名
	private String MajorChairman;// 系主任
	private String MajorTel;// 系联系方式
	private int DeptNum;//所在学院

	public int getMajorNum() {
		return MajorNum;
	}

	public void setMajorNum(int majorNum) {
		MajorNum = majorNum;
	}

	public String getMajorName() {
		return MajorName;
	}

	public void setMajorName(String majorName) {
		MajorName = majorName;
	}

	public String getMajorChairman() {
		return MajorChairman;
	}

	public void setMajorChairman(String majorChairman) {
		MajorChairman = majorChairman;
	}

	public String getMajorTel() {
		return MajorTel;
	}

	public void setMajorTel(String majorTel) {
		MajorTel = majorTel;
	}

	public int getDeptNum() {
		return DeptNum;
	}

	public void setDeptNum(int deptNum) {
		DeptNum = deptNum;
	}

	@Override
	public String toString() {
		return "Major [MajorNum=" + MajorNum + ", MajorName=" + MajorName
				+ ", MajorChairman=" + MajorChairman + ", MajorTel=" + MajorTel
				+ ", DeptNum=" + DeptNum + "]";
	}

	
}

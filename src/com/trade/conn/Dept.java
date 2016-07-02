package com.trade.conn;

public class Dept {
	private int deptno;
	private String deptname;
	private int age;
	
	public int getDeptno() {
		return deptno;
	}
	
	public void setDeptno(int deptno) {
		this.deptno=deptno;
	}
	
	public String getDeptname() {
		return deptname;
	}
	
	public void setDeptname(String deptname) {
		this.deptname=deptname;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public String toString() {
		String outString = "deptno="+deptno + "\tdeptname=" + deptname + "\tage=" + age;
		return outString;
	}
}

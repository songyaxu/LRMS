package com.lrms.entity;

public class User {
	private int id;
	private String no;
	private String name;
	private String pwd;
	private int type; //登录用户类型 0. 游客  1：学生 2，教师  3.管理员
	public User(){
		
	}
	public User(int id,String no,String name,String pwd,int type){
		this.id=id;
		this.no=no;
		this.name=name;
		this.pwd=pwd;
		this.type=type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}

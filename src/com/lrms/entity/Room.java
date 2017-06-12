package com.lrms.entity;

/**
 * @author songyx
 *
 */
public class Room {
	private int id;
	private int stuNum;        //容纳人数
	private String name;       //名称
	private String location;   //位置
	private String remark;     //备注
	private int state;         //状态      非持久化字段，数据库里边没有这个字段
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}

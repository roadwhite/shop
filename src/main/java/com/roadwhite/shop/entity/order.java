package com.roadwhite.shop.entity;

/**
 * 文件名称 : order.java 内容摘要 :
 * 
 * @author White
 * @Version 2020年10月8日
 */
public class order {
	String ordernum;
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getGlod() {
		return glod;
	}
	public void setGlod(double glod) {
		this.glod = glod;
	}
	public String getBool() {
		return bool;
	}
	public void setBool(String bool) {
		this.bool = bool;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	String time;
	double glod;
	String bool;
	String roomid;
}

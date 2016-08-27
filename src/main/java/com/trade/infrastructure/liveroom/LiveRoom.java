package com.trade.infrastructure.liveroom;

public class LiveRoom {

	private int room_id;
	private Long user_id;
	private String city;
	private String name;
	private String portrait;
	private int online_users_count;
	private String url;
	private String title;
	private String cover;
	private String gmt_create;
	private String flow_status;
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public int getOnline_users_count() {
		return online_users_count;
	}
	public void setOnline_users_count(int online_users_count) {
		this.online_users_count = online_users_count;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}
	public String getFlow_status() {
		return flow_status;
	}
	public void setFlow_status(String flow_status) {
		this.flow_status = flow_status;
	}
	
	
}
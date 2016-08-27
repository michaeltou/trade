package com.trade.infrastructure.address;

public class AddressDO {

	private Long user_addr_id;
	private Long user_id;
	private String detail_addr;
	private String province;
	private String city;
	private String name;
	private int phone;
	private int cell_phone;
	private int type;
	public Long getUser_addr_id() {
		return user_addr_id;
	}
	public void setUser_addr_id(Long user_addr_id) {
		this.user_addr_id = user_addr_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getDetail_addr() {
		return detail_addr;
	}
	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getCell_phone() {
		return cell_phone;
	}
	public void setCell_phone(int cell_phone) {
		this.cell_phone = cell_phone;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}

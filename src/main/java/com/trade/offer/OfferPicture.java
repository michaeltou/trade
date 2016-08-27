package com.trade.offer;

import java.util.Date;


public class OfferPicture {

	private long pic_id;
	private long offer_id;
	private String gmt_create;
	private String gmt_modified;
	private String pic_url;
	private int pic_status;
	private String pic_desc;
	private int pic_type;
	
	
	public int getPic_type() {
		return pic_type;
	}
	public void setPic_type(int pic_type) {
		this.pic_type = pic_type;
	}
	public long getPic_id() {
		return pic_id;
	}
	public void setPic_id(long pic_id) {
		this.pic_id = pic_id;
	}
	public long getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(long offer_id) {
		this.offer_id = offer_id;
	}
	public String getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}
	public String getGmt_modified() {
		return gmt_modified;
	}
	public void setGmt_modified(String gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public int getPic_status() {
		return pic_status;
	}
	public void setPic_status(int pic_status) {
		this.pic_status = pic_status;
	}
	public String getPic_desc() {
		return pic_desc;
	}
	public void setPic_desc(String pic_desc) {
		this.pic_desc = pic_desc;
	}
	
	
}

package com.trade.offer;

public class Offer {
	private long offer_id;
	private int sku_id;
	private String offer_name;
	private String offer_detail;
	private int offer_seller_id;
	private int offer_org_price;
	private int offer_pro_price;
	private int offer_qty;
	private String offer_tag;
	private String offer_attribute;
	private String gmt_create;
	private String gmt_modified;
	private int offer_status;
	
	
	public String getOffer_attribute() {
		return offer_attribute;
	}
	public void setOffer_attribute(String offer_attribute) {
		this.offer_attribute = offer_attribute;
	}
	public int getOffer_org_price() {
		return offer_org_price;
	}
	public void setOffer_org_price(int offer_org_price) {
		this.offer_org_price = offer_org_price;
	}
	public int getOffer_seller_id() {
		return offer_seller_id;
	}
	public void setOffer_seller_id(int offer_seller_id) {
		this.offer_seller_id = offer_seller_id;
	}
	public long getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(long offer_id) {
		this.offer_id = offer_id;
	}
	public int getOffer_pro_price() {
		return offer_pro_price;
	}
	public void setOffer_pro_price(int offer_pro_price) {
		this.offer_pro_price = offer_pro_price;
	}
	public String getOffer_tag() {
		return offer_tag;
	}
	public void setOffer_tag(String offer_tag) {
		this.offer_tag = offer_tag;
	}
	public int getOffer_qty() {
		return offer_qty;
	}
	public void setOffer_qty(int offer_qty) {
		this.offer_qty = offer_qty;
	}
	public String getOffer_name() {
		return offer_name;
	}
	public void setOffer_name(String offer_name) {
		this.offer_name = offer_name;
	}
	public long getSku_id() {
		return sku_id;
	}
	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}
	public String getOffer_detail() {
		return offer_detail;
	}
	public void setOffer_detail(String offer_detail) {
		this.offer_detail = offer_detail;
	}
	public String getGmt_modified() {
		return gmt_modified;
	}
	public void setGmt_modified(String gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	public String getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}
	public int getOffer_status() {
		return offer_status;
	}
	public void setOffer_status(int offer_status) {
		this.offer_status = offer_status;
	}
	
	public String toString() {
		String ret = "offer_id=" + Long.toString(offer_id) + "\toffer_name=" + offer_name;
		return  ret;
	}

}

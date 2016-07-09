package com.trade.tradeOrder;

public class TradeOrder {
	private int order_id;
	private int buyer_id;
	private int seller_id;
	private String flow_status;
	private String pay_status;
	private String logistics_status;
	private int order_total_qty;
	private String  order_total_money;
	private String  order_total_paid_money;
	private String  order_refund_id;
	private String  gmt_create;
	private String  gmt_modified ;
	
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public String getFlow_status() {
		return flow_status;
	}

	public void setFlow_status(String flow_status) {
		this.flow_status = flow_status;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

	public String getLogistics_status() {
		return logistics_status;
	}

	public void setLogistics_status(String logistics_status) {
		this.logistics_status = logistics_status;
	}

	public int getOrder_total_qty() {
		return order_total_qty;
	}

	public void setOrder_total_qty(int order_total_qty) {
		this.order_total_qty = order_total_qty;
	}

	public String getOrder_total_money() {
		return order_total_money;
	}

	public void setOrder_total_money(String order_total_money) {
		this.order_total_money = order_total_money;
	}

	public String getOrder_total_paid_money() {
		return order_total_paid_money;
	}

	public void setOrder_total_paid_money(String order_total_paid_money) {
		this.order_total_paid_money = order_total_paid_money;
	}

	public String getOrder_refund_id() {
		return order_refund_id;
	}

	public void setOrder_refund_id(String order_refund_id) {
		this.order_refund_id = order_refund_id;
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

	
		
    public String toString() {
			String outString = "order_id="+ order_id 
					      + "\tbuyer_id=" + buyer_id
					      + "\tseller_id=" + seller_id
					      + "\tflow_status" + flow_status
					      + "\tpay_status"  + pay_status
                          + "\tlogistics_status" + logistics_status
                          + "\torder_total_qty" + order_total_qty
					      + "\torder_total_money" + order_total_money
					      + "\torder_total_paid_money" + order_total_paid_money
					      + "\torder_refund_id" + order_refund_id
					      + "\tgmt_create" + gmt_create
					      + "\tgmt_modified" + gmt_modified
					      ;
			return outString;
		}
	


}



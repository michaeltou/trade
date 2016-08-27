package com.trade.infrastructure.address;

public enum AddressType {
    
	BUYER_RECEIVE_ADDRESS("buyer_receive_address",0),
	SELLER_SEND_GOODS_ADDRESS("seller_send_goods_address",1),
	SELLER_RETURN_GOODS_ADDRESS("seller_return_goods_address",2)
	
	;
	
	private String addressType;
	private int addressTypeCode;
	
	private AddressType(String addressType,int addressTypeCode){
		this.addressType = addressType;
		this.addressTypeCode = addressTypeCode;
	}
	
	public int getAddressType(){
		return this.addressTypeCode;
	}
}

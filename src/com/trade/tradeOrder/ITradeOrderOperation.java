package com.trade.tradeOrder;
import java.util.List;
public interface ITradeOrderOperation {
	    public TradeOrder getTradeOrderByOrderID(int order_id);
	    
	    public List<TradeOrder> getTradeOrderByBuyerID(String buyer_id);
	    
	    public List<TradeOrder> getTradeOrderBySellerID(int seller_id);
	    
	    public void addTradeOrder(TradeOrder tradeOrder);
	    
	    public void updateTradeOrder(TradeOrder tradeOrder);
	    
	    public void deleteTradeOrder(int order_id);

}

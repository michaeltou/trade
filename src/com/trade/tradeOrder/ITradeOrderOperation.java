package com.trade.tradeOrder;
import java.util.List;
public interface ITradeOrderOperation {
	    public TradeOrder selectTradeOrderByOrderID(int order_id);
	    
	    public List<TradeOrder> selectTradeOrderByBuyerID(int Buyer_id);
	    
	    public List<TradeOrder> selectTradeOrderBySellerID(int Seller_id);
	    
	    public void addTradeOrder(TradeOrder tradeOrder);
	    
	    public void updateTradeOrder(TradeOrder tradeOrder);
	    
	    public void deleteTradeOrder(int order_id);

}

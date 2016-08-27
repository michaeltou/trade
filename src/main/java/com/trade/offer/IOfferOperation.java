package com.trade.offer;

import java.util.List;

public interface IOfferOperation {
	public Offer getOfferById(int id);
	
	public List<Offer> getOfferByName(String name);

	public List<Offer> getOfferByRoomid(int roomid);	
	
	public void addOffer(Offer offer);
	
	public void updateOffer(Offer offer);
	
	public void delOffer(Offer offer);
	
}

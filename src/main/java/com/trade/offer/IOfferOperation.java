package com.trade.offer;

import java.util.List;

public interface IOfferOperation {
	public Offer getOfferById(long id);
	
	public List<Offer> getOfferByName(String name);

	public List<Offer> getOfferByRoomid(int roomid);	
	
	public void addOffer(Offer offer);
	
	public void updateOffer(Offer offer);
	
	public void delOffer(Offer offer);
	
	
	public void addOfferPicture(OfferPicture offerPicture);
	
	List<OfferPicture> selectByOfferIdAndPictype(OfferPicture offerPicture);
	
	void deleteOfferPictureByOfferId(long offerId);
	
}

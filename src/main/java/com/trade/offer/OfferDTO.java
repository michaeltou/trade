package com.trade.offer;

import java.util.List;

public class OfferDTO {

	private Offer offerDetail;
	
	private List<OfferPicture> offerPictureList;

	public Offer getOfferDetail() {
		return offerDetail;
	}

	public void setOfferDetail(Offer offerDetail) {
		this.offerDetail = offerDetail;
	}

	public List<OfferPicture> getOfferPictureList() {
		return offerPictureList;
	}

	public void setOfferPictureList(List<OfferPicture> offerPictureList) {
		this.offerPictureList = offerPictureList;
	}
	
	
	
}

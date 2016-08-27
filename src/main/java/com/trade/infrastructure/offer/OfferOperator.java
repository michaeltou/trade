package com.trade.infrastructure.offer;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;

import com.trade.infrastructure.MyBatisOperator;
import com.trade.offer.IOfferOperation;
import com.trade.offer.Offer;
import com.trade.offer.OfferDTO;
import com.trade.offer.OfferPicture;

public class OfferOperator extends MyBatisOperator{

	 public Offer getOfferById(long id) {
	    	SqlSession session = mSessionFactory.openSession();
	    	Offer offer = null;
	    	try {
	    		IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
	    		offer = oCInterface.getOfferById(id);
	    		if(offer != null) {
	    			System.out.println("根据id查offer：" + offer);
	    		} else {
	    			System.out.println("根据id查offer is NULL");
	    		}
	    	} catch(Exception e){
	    		log.error("getOfferById failed,args:"+id,e);
	    	}
	    	finally {
	    		session.close();
	    	}
	    	
			return offer;
	    }
	    public List<Offer> getOfferByName(String name) {
	    	SqlSession session = mSessionFactory.openSession();
	    	List<Offer> offerList = null;
	    	try {
	    		IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
	    		offerList = oCInterface.getOfferByName(name);
	    		
	    	} catch(Exception e){
	    		log.error("getOfferByName failed,args:"+name,e);
	    	}
	    	finally {
	    		session.close();
	    	}
	    	
			return offerList;
	    }
	    public List<Offer> getOfferByRoomid(int roomid) {
	    	SqlSession session = mSessionFactory.openSession();
	    	List<Offer> offerList = null;
	    	try {
	    		IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
	    		offerList = oCInterface.getOfferByRoomid(roomid);
	    		if(offerList != null) {
	    			System.out.println("根据直播房间号查offer：" + offerList);
	    		}
	    	} catch(Exception e){
	    		log.error("getOfferByRoomid failed,args:"+roomid,e);
	    	}finally {
	    		session.close();
	    	}
	    	
			return offerList;
	    }
	    public Offer addOffer(Offer offer) {
	    	SqlSession session = mSessionFactory.openSession();
	    	try {
	    		IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
	    		oCInterface.addOffer(offer);
	    		session.commit();
	    	}catch(Exception e){
	    		log.error("addOffer failed,args:"+JSONObject.fromObject(offer).toString(),e);
	    	} finally {
	    		session.close();
	    	}
	    	return offer;
	    }
	    public void delOffer(Offer offer) {
	    	SqlSession session = mSessionFactory.openSession();
	    	try {
	    		IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
	    		oCInterface.delOffer(offer);
	    		session.commit();
	    	} catch(Exception e){
	    		log.error("del failed,args:"+JSONObject.fromObject(offer).toString(),e);
	    	}finally {
	    		session.close();
	    	}
	    }
	    
	   public void addOfferPicture(List<OfferPicture> offerPictureList){
		     if(null == offerPictureList || offerPictureList.isEmpty()){
		    	 return;
		     }
	   	     SqlSession session = mSessionFactory.openSession();
	          try{
	        	  IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
	        	  for(OfferPicture offerPicture:offerPictureList){
	        		  oCInterface.addOfferPicture(offerPicture);
	        	  }
	        	  session.commit();
	          }catch(Exception e){
	        	  log.error("addOfferPicture faileds,args:"+JSONObject.fromObject(offerPictureList).toString(),e);       	 
	          }
	          finally {
	      		session.close();
	      	}
	   }
	   
	   public List<OfferPicture> getOfferPictureByOfferId(long offer_id,int pic_type ){
		   
		   List<OfferPicture> offerPictureList = null;
		   
		   SqlSession session = mSessionFactory.openSession();
	       try{
	     	  IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
	     	  OfferPicture  offerPicture = new OfferPicture();
	     	  offerPicture.setOffer_id(offer_id);
	     	  offerPicture.setPic_type(pic_type);
	     	  offerPictureList = oCInterface.selectByOfferIdAndPictype(offerPicture);
	     	  System.out.println("查询商品图片list：" + offerPictureList);
	       }catch(Exception e){
	    	   log.error("getOfferPictureByOfferId failed,offer_id:"+offer_id+";pic_type:"+pic_type,e);       	 
	       }
	       finally {
	   		session.close();
	     	}
	       return offerPictureList;
	   }
	   
	   public void deleteOfferPictureByOfferId(long offerId){
		
	 	     SqlSession session = mSessionFactory.openSession();
	        try{
	      	  IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
	      	  oCInterface.deleteOfferPictureByOfferId(offerId);
	      	  session.commit();
	      	  System.out.println("删除商品图片：" + offerId);
	        }catch(Exception e){
		    	   log.error("deleteOfferPictureByOfferId,offer_id:"+offerId,e);       	 
	        }
	        finally {
	    		session.close();
	    	}
	   }
	   
	   public OfferDTO getOffer(long offerId,int pic_type){
		   OfferDTO offer = new OfferDTO();
		   offer.setOfferDetail(getOfferById(offerId));
		   if(pic_type != -1){
			   offer.setOfferPictureList(getOfferPictureByOfferId(offerId,pic_type));
		   }
		   
		   return offer;
	   }
	    
	   
}

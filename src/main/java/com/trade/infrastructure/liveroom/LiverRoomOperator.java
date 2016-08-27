package com.trade.infrastructure.liveroom;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;

import com.trade.infrastructure.MyBatisOperator;
import com.trade.liveroom.ILiveRoomOperation;

public class LiverRoomOperator extends MyBatisOperator{

	
	public LiveRoom getliveRoomByRoomID(int roomID) {
    	SqlSession session = mSessionFactory.openSession();
    	LiveRoom liveRoom =null;
    	try {
    		ILiveRoomOperation oCInterface = session.getMapper(ILiveRoomOperation.class);
    		liveRoom = oCInterface.getLiveRoomByRoomID(roomID);
    		if(liveRoom != null) {
    			log.info("根据roomID查liveRoom：" + liveRoom);
    		} else {
    			log.info("根据roomID查liveRoom is NULL");
    		}
    	} catch(Exception e){
    		log.error("getliveRoomByRoomId failed args:"+roomID,e);
    	}
    	finally {
    		session.close();
    	}
    	
		return liveRoom;
    }
    public List<LiveRoom> getTopLiveRoomList(int count) {
    	SqlSession session = mSessionFactory.openSession();
    	List<LiveRoom> liveRoomList =null;
    	try {
    		ILiveRoomOperation oCInterface = session.getMapper(ILiveRoomOperation.class);
    		liveRoomList = oCInterface.getTopLiveRoomList(count);
    		if(liveRoomList != null) {
    			log.info("根据onLineUsersCount查LiveRoom：" + liveRoomList);
    		}
    	}catch(Exception e){
    		log.error("getTopLiveRoomList faield,args:"+count,e);
    	}
    	finally {
    		session.close();
    	}
    	
		return liveRoomList;
    }
    
    public List<LiveRoom> getLiveRoomByGmtCreateList(String gmtCreate) {
    	SqlSession session = mSessionFactory.openSession();
    	List<LiveRoom> liveRoomList = null;
    	try {
    		ILiveRoomOperation oCInterface = session.getMapper(ILiveRoomOperation.class);
    		liveRoomList = oCInterface.getLiveRoomByGmtCreate(gmtCreate);
    		if(liveRoomList != null) {
    			log.info("根据gmtCreate查LiveRoom：" + liveRoomList);
    		}
    	} catch(Exception e){
    		log.error("getLiveRoomByGmtCreateList failed,args:"+gmtCreate,e);
    	}
    	finally {
    		session.close();
    	}
    	
		return liveRoomList;
    }
    
    public LiveRoom addLiveRoom(LiveRoom liveRoom) {
    	SqlSession session = mSessionFactory.openSession();
    	try {
    		ILiveRoomOperation oCInterface = session.getMapper(ILiveRoomOperation.class);
    		oCInterface.addLiveRoom(liveRoom);
    		session.commit();
    		log.info("新增liveRoom：" + liveRoom);
    	}catch(Exception e){
    		log.error("addLiveRoom faield,args;"+JSONObject.fromObject(liveRoom).toString(),e);
    	}
    	finally {
    		session.close();
    	}
    	return liveRoom;
    }
    public void delLiveRoom(LiveRoom liveRoom) {
    	SqlSession session = mSessionFactory.openSession();
    	try {
    		ILiveRoomOperation oCInterface = session.getMapper(ILiveRoomOperation.class);
    		oCInterface.delLiveRoom(liveRoom);
    		session.commit();
    		log.info("删除liveRoom：" + liveRoom);
    	}catch(Exception e){
    		log.error("delLiveRoom faield,args:"+JSONObject.fromObject(liveRoom).toString(),e);
    			
    	}
    	finally {
    		session.close();
    	}
    }
    
}
    
   

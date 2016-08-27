package com.trade.liveroom;


import java.util.List;

public interface ILiveRoomOperation {
	public LiveRoom getLiveRoomByRoomID(int roomID);
	
	public List<LiveRoom> getTopLiveRoomList(int count);
	
	public List<LiveRoom> getLiveRoomByGmtCreate(String gmtCreate);
	
	public void addLiveRoom(LiveRoom liveRoom);
	
	public void updateLiveRoom(LiveRoom liveRoom);
	
	public void delLiveRoom(LiveRoom liveRoom);
	
}
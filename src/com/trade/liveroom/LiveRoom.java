package com.trade.liveroom;

public class LiveRoom {
    private long roomID;
	private long  userID;
	private String city;
	private String name;
	private String portrait;
	private long onLineUsersCount;
	private String url;
	private String title;
	private String cover;
	private String gmtCreate;
	private String roomStatus;



	public long getRoomID() {
		return roomID;
	}


	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}
	
	
	public long getUserID() {
		return userID;
	}




	public void setUserID(long userID) {
		this.userID = userID;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPortrait() {
		return portrait;
	}




	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}




	public long getOnLineUsersCount() {
		return onLineUsersCount;
	}




	public void setOnLineUsersCount(long onLineUsersCount) {
		this.onLineUsersCount = onLineUsersCount;
	}




	public String getUrl() {
		return url;
	}




	public void setUrl(String url) {
		this.url = url;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getCover() {
		return cover;
	}




	public void setCover(String cover) {
		this.cover = cover;
	}

	
	public String getGmtCreate() {
		return gmtCreate;
	}




	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getRoomStatus() {
		return roomStatus;
	}


	public void setRoomStatus(String roomStatus) {
		roomStatus = roomStatus;
	}

		
    public String toString() {
			String outString = "roomID" + roomID
					      + "userID="+ userID 
					      + "\tcity=" + city
					      + "\tname=" + name
					      + "\tportrait" + portrait
					      + "\tonline_users_count"  + onLineUsersCount
                          + "\turl" + url
                          + "\ttitle" + title
					      + "\tcover" + cover
					      + "\tgmt_create" + gmtCreate
					      + "\troomStatus" + roomStatus
					      ;
			return outString;
		}
	


}



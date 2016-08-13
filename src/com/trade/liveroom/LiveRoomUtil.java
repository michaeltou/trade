package com.trade.liveroom;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import com.trade.conn.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class LiveRoomUtil {
	
	private SqlSessionFactory mSessionFactory;

	//String resource = "conf.xml";
    public void init(String resource) throws IOException {
        //mybatis的配置文件
    	if(resource == null || resource.isEmpty()) resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = LiveRoomUtil.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        mSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        //mSession = mSessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
    }
    
    public LiveRoom getliveRoomByRoomID(int roomID) {
    	SqlSession session = mSessionFactory.openSession();
    	LiveRoom liveRoom;
    	try {
    		ILiveRoomOperation oCInterface = session.getMapper(ILiveRoomOperation.class);
    		liveRoom = oCInterface.getLiveRoomByRoomID(roomID);
    		if(liveRoom != null) {
    			System.out.println("根据roomID查liveRoom：" + liveRoom);
    		} else {
    			System.out.println("根据roomID查liveRoom is NULL");
    		}
    	} finally {
    		session.close();
    	}
    	
		return liveRoom;
    }
    public List<LiveRoom> getLiveRoomByOnLineUsersCount(int onLineUsersCount) {
    	SqlSession session = mSessionFactory.openSession();
    	List<LiveRoom> liveRoomList;
    	try {
    		ILiveRoomOperation oCInterface = session.getMapper(ILiveRoomOperation.class);
    		liveRoomList = oCInterface.getLiveRoomByOnLineUsersCount(onLineUsersCount);
    		if(liveRoomList != null) {
    			System.out.println("根据onLineUsersCount查LiveRoom：" + liveRoomList);
    		}
    	} finally {
    		session.close();
    	}
    	
		return liveRoomList;
    }
    
    public List<LiveRoom> getLiveRoomByGmtCreateList(String gmtCreate) {
    	SqlSession session = mSessionFactory.openSession();
    	List<LiveRoom> liveRoomList;
    	try {
    		ILiveRoomOperation oCInterface = session.getMapper(ILiveRoomOperation.class);
    		liveRoomList = oCInterface.getLiveRoomByGmtCreate(gmtCreate);
    		if(liveRoomList != null) {
    			System.out.println("根据gmtCreate查LiveRoom：" + liveRoomList);
    		}
    	} finally {
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
    		System.out.println("新增liveRoom：" + liveRoom);
    	} finally {
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
    		System.out.println("删除liveRoom：" + liveRoom);
    	} finally {
    		session.close();
    	}
    }
    
    public static void main(String[] args) {
    	try {
    		LiveRoomUtil util = new LiveRoomUtil();
    		util.init("conf.xml");
    		LiveRoom liveRoom = new LiveRoom();

    		liveRoom.setRoomID(2);
    		liveRoom.setUserID(3);
    		liveRoom.setCity("hangzhou");
    		liveRoom.setName("room_name1");
    		liveRoom.setPortrait("21");
    		liveRoom.setOnLineUsersCount(100);
    		liveRoom.setUrl("/tzb.com");
    		liveRoom.setTitle("mingzi");
    		liveRoom.setCover("/photo/01.jpg");
    		liveRoom.setGmtCreate("2016-07-09 00:00:00");
    	} catch(Exception e) {
    		//System.out.println(e.getStackTrace());
    		e.printStackTrace();
    	}
    }
}

package com.trade.infrastructure.user;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;

import com.trade.infrastructure.MyBatisOperator;
import com.trade.user.IUserOperation;
import com.trade.user.User;

public class UserOperator extends MyBatisOperator{

    public User selectUserByID(long userId){
    	User user = null;
    	SqlSession session = mSessionFactory.openSession();
    	try{
    		IUserOperation userOperation = session.getMapper(IUserOperation.class);
    		user = userOperation.selectUserByID(userId);
    	}catch(Exception e){
    		log.error("selectUserByID failed,args:"+userId,e);
    	}finally{
    		session.close();
    	}
    	return user;
    }
	
	public List<User> selectUserList(String userName){
		List<User> result = null;
    	SqlSession session = mSessionFactory.openSession();
    	try{
    		IUserOperation userOperation = session.getMapper(IUserOperation.class);
    		result = userOperation.selectUserList(userName);
    	}catch(Exception e){
    		log.error("selectUserList failed,args:"+userName,e);
    	}finally{
    		session.close();
    	}
    	return result;
	}
	
	public int addUser(User user){
		int result = -1;
		SqlSession session = mSessionFactory.openSession();
    	try{
    		IUserOperation userOperation = session.getMapper(IUserOperation.class);
    		userOperation.addUser(user);
    		session.commit();
    		result = 1;
    	}catch(Exception e){
    		log.error("addUser failed,args:"+JSONObject.fromObject(user).toString(),e);
    	}finally{
    		session.close();
    	}
    	return result;
	}
	
	public int updateUser(User user){
		return 0;
	}
	
	public int deleteUser(long userId){
		return -1;
	}
}

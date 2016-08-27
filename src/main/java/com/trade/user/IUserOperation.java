package com.trade.user;

import java.util.List;


public interface IUserOperation {
	
	public User selectUserByID(long userId);
	
	public List<User> selectUserList(String userName);
	
	public int addUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(long userId);

}

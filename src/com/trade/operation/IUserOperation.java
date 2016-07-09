package com.trade.operation;

import java.util.List;

import com.trade.user.User;

public interface IUserOperation {
	
	public User selectUserByID(int userId);
	
	public List<User> selectUserList(String userName);
	
	public int addUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(int userId);

}

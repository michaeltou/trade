package com.chat;

import java.util.List;

public interface IMessageOperation {
	public Message getMessageById(int id);
	
	public List<Message> getMessageByName(String name);
	
	public List<Message> getMessageByGmt_create(String gmt_create);
	
	public void addMessage(Message message);
	
	public void delMessage(Message message);
	
}

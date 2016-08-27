package com.trade.infrastructure.chatMessage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.chat.IMessageOperation;
import com.chat.Message;
import com.trade.infrastructure.MyBatisOperator;

public class MessageOperator extends MyBatisOperator{

	public Message getMessageById(int id) {
    	SqlSession session = mSessionFactory.openSession();
    	Message message;
    	try {
    		IMessageOperation oMInterface = session.getMapper(IMessageOperation.class);
    		message = oMInterface.getMessageById(id);
    		if(message != null) {
    			System.out.println("根据id查message：" + message);
    		} else {
    			System.out.println("根据id查message is NULL");
    		}
    	} finally {
    		session.close();
    	}
    	
		return message;
    }
    
    public List<Message> getMessageByName(String name) {
    	SqlSession session = mSessionFactory.openSession();
    	List<Message> messageList;
    	try {
    		IMessageOperation oMInterface = session.getMapper(IMessageOperation.class);
    		messageList = oMInterface.getMessageByName(name);
    		if(messageList != null) {
    			System.out.println("根据name查message：" + messageList);
    		}
    	} finally {
    		session.close();
    	}
    	
		return messageList;
    }
    public List<Message> getMessageByMgt_create(String gmt_create) {
    	SqlSession session = mSessionFactory.openSession();
    	List<Message> messageList;
    	try {
    		IMessageOperation oMInterface = session.getMapper(IMessageOperation.class);
    		messageList = oMInterface.getMessageByName(gmt_create);
    		if(messageList != null) {
    			System.out.println("根据name查message：" + messageList);
    		}
    	} finally {
    		session.close();
    	}
    	
		return messageList;
    }
    public List<Message> getMessageTop(int size) {
    	SqlSession session = mSessionFactory.openSession();
    	List<Message> messageList;
    	try {
    		IMessageOperation oMInterface = session.getMapper(IMessageOperation.class);
    		messageList = oMInterface.getMessageTop(size);
    		if(messageList != null) {
    			System.out.println("根据name查message：" + messageList);
    		}
    	} finally {
    		session.close();
    	}
    	
		return messageList;
    }
    public Message addMessage(Message message) {
    	SqlSession session = mSessionFactory.openSession();
    	try {
    		IMessageOperation oMInterface = session.getMapper(IMessageOperation.class);
    		oMInterface.addMessage(message);
    		session.commit();
    		System.out.println("新增message：" + message);
    	} finally {
    		session.close();
    	}
    	return message;
    }
    public void delMessage(Message message) {
    	SqlSession session = mSessionFactory.openSession();
    	try {
    		IMessageOperation oMInterface = session.getMapper(IMessageOperation.class);
    		oMInterface.delMessage(message);
    		session.commit();
    		System.out.println("删除message：" + message);
    	} finally {
    		session.close();
    	}
    }
}

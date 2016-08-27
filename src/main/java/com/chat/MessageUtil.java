package com.chat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MessageUtil {
	
	private SqlSessionFactory mSessionFactory;

	//String resource = "conf.xml";
    public void init(String resource) throws IOException {
        //mybatis的配置文件
    	if(resource == null || resource.isEmpty()) resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MessageUtil.class.getClassLoader().getResourceAsStream(resource);
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
    
    public static void main(String[] args) {
    	try {
    		MessageUtil util = new MessageUtil();
    		util.init("conf.xml");
    		Message message = new Message();
    		message.setMessage_id(1);
    		message.setRoom_id(0);
    		message.setSender_id(2);
    		message.setReceiver_id(5);
    		message.setMessage("hello world!");
    		message.setStatus(0);
    		message.setGmt_create("2016-07-15 00:00:00");
    		//util.addMessage(message);
    		util.getMessageById(1);
    		//util.getMessageByName("%abc%");
    		//util.delMessage(message);
    	} catch(Exception e) {
    		//System.out.println(e.getStackTrace());
    		e.printStackTrace();
    	}
    }
}

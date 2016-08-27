package com.trade.infrastructure;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisOperator {

    protected static SqlSessionFactory mSessionFactory;
	
	protected static final Log log =LogFactory.getLog(MyBatisOperator.class);
	
	static{
		try{
    		String resource = "conf.xml";
        	String path= MyBatisOperator.class.getResource("/").getPath();
        	resource=path+resource;
        	log.warn("resouce path:"+resource);
            //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
            InputStream is = new FileInputStream(new File(resource));
            
            if(is == null){
            	log.error("read file:"+resource+";because it is faield");
            }
            //构建sqlSession的工厂
            mSessionFactory = new SqlSessionFactoryBuilder().build(is);
    	}catch(Exception e){
    		log.error("init failed",e);
    	}
	}
}

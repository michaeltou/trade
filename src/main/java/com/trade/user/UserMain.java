package com.trade.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.trade.json.Json;

public class UserMain {

    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = UserMain.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        
       
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
/*        String statement = "com.trade.mapping.userMapper.selectUserByID";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);
        */
        
        IUserOperation userOperation=session.getMapper(IUserOperation.class);
       
   //     selectUserById(userOperation);
       
   //  addUser(userOperation);
     selectUserList(userOperation);
     //   updateUser(userOperation);
       // deleteUser(userOperation);
        
        
       session.commit(); 
       session.close();
    }
    
    public   static void selectUserById(IUserOperation userOperation){ 
        User user = userOperation.selectUserByID(1);
        System.out.println(user);
     
    	
    }
    public   static void selectUserList(IUserOperation userOperation){
    	
    	   List<User> userList =  userOperation.selectUserList("%wan%");
           JSONArray object = JSONArray.fromObject(userList);
            System.out.println(object.toString() ); 
            
    }
    public static  void addUser( IUserOperation userOperation){

        User addUser  = new User();
        addUser.setUserId("3");
        addUser.setUserName("wang\\%"); 
       userOperation.addUser(addUser); 
          System.out.println("insert successfully");
    }
    
    public static  void updateUser( IUserOperation userOperation){

        User updateUser  = new User();
        updateUser.setUserId("2");
        updateUser.setUserName("wangxin"); 
       userOperation.updateUser( updateUser);
       System.out.println("update successfully");
    }
    
    public static  void deleteUser( IUserOperation userOperation){

       
       userOperation.deleteUser( 2);
          System.out.println("delete successfully");
    }
    
    
    
}
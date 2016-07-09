package com.trade.offer;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import com.trade.conn.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class OfferUtil {
	
	private SqlSessionFactory mSessionFactory;

	//String resource = "conf.xml";
    public void init(String resource) throws IOException {
        //mybatis的配置文件
    	if(resource == null || resource.isEmpty()) resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = OfferUtil.class.getClassLoader().getResourceAsStream(resource);
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
    
    public Offer getOfferById(int id) {
    	SqlSession session = mSessionFactory.openSession();
    	Offer offer;
    	try {
    		IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
    		offer = oCInterface.getOfferById(id);
    		if(offer != null) {
    			System.out.println("根据id查offer：" + offer);
    		} else {
    			System.out.println("根据id查offer is NULL");
    		}
    	} finally {
    		session.close();
    	}
    	
		return offer;
    }
    public List<Offer> getOfferByName(String name) {
    	SqlSession session = mSessionFactory.openSession();
    	List<Offer> offerList;
    	try {
    		IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
    		offerList = oCInterface.getOfferByName(name);
    		if(offerList != null) {
    			System.out.println("根据name查offer：" + offerList);
    		}
    	} finally {
    		session.close();
    	}
    	
		return offerList;
    }
    public Offer addOffer(Offer offer) {
    	SqlSession session = mSessionFactory.openSession();
    	try {
    		IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
    		oCInterface.addOffer(offer);
    		session.commit();
    		System.out.println("新增offer：" + offer);
    	} finally {
    		session.close();
    	}
    	return offer;
    }
    public void delOffer(Offer offer) {
    	SqlSession session = mSessionFactory.openSession();
    	try {
    		IOfferOperation oCInterface = session.getMapper(IOfferOperation.class);
    		oCInterface.delOffer(offer);
    		session.commit();
    		System.out.println("删除offer：" + offer);
    	} finally {
    		session.close();
    	}
    }
    
    public static void main(String[] args) {
    	try {
    		OfferUtil util = new OfferUtil();
    		util.init("conf.xml");
    		Offer offer = new Offer();
    		offer.setOffer_id(2);
    		offer.setOffer_status(0);
    		offer.setOffer_detail("welcome");
    		offer.setOffer_name("123abc456");
    		offer.setSku_id(21);
    		offer.setOffer_attribute("address:beijing");
    		offer.setOffer_org_price(100);
    		offer.setOffer_qty(10000);
    		offer.setOffer_pro_price(10);
    		offer.setGmt_create("2016-07-09 00:00:00");
    		offer.setGmt_modified("2016-07-10 00:00:00");
    		offer.setOffer_seller_id(10);
    		offer.setOffer_tag("promotion");
    		//util.addOffer(offer);
    		util.getOfferById(1);
    		util.getOfferByName("%abc%");
    		util.delOffer(offer);
    	} catch(Exception e) {
    		//System.out.println(e.getStackTrace());
    		e.printStackTrace();
    	}
    }
}

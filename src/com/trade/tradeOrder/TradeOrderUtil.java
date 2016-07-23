package com.trade.tradeOrder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.trade.offer.Offer;
import com.trade.offer.OfferUtil;

public class TradeOrderUtil {

	private SqlSessionFactory wSessionFactory;

	//String resource = "conf.xml";
    public void init(String resource) throws IOException {
        //mybatis的配置文件
    	if(resource == null || resource.isEmpty()) resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = OfferUtil.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        wSessionFactory = new SqlSessionFactoryBuilder().build(is);
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
    public void getTradeOrderByOrderID(int order_id) {
        SqlSession session = wSessionFactory.openSession();
        try {
            ITradeOrderOperation iTradeOrderOperation = session
                    .getMapper(ITradeOrderOperation.class);
            TradeOrder tradeOrder = iTradeOrderOperation.getTradeOrderByOrderID(order_id);
            if (tradeOrder != null) {
                System.out.println(
                		tradeOrder.getOrder_id() + 
                		"buyer_id:" + tradeOrder.getBuyer_id() + 
                		"seler_id:" + tradeOrder.getSeller_id() +
                		"flow_status:" + tradeOrder.getFlow_status() +
                		"pay_status:" + tradeOrder.getPay_status() +
                		"logistics_status:" + tradeOrder.getLogistics_status() +
                		"total_qty:" + tradeOrder.getOrder_total_qty() +
                		"total_money:" + tradeOrder.getOrder_total_money() +
                		"paid_money:" + tradeOrder.getOrder_total_paid_money() +
                		"refund_id:" + tradeOrder.getOrder_refund_id() +
                		"gmt_create:" + tradeOrder.getGmt_create() + 
                		"gmt_modified:" + tradeOrder.getGmt_modified()    		
                		);
            }

        } finally {
            session.close();
        }
    }

    public void getTradeOrderBuyerID(String buyer_id) {
    	  SqlSession session = wSessionFactory.openSession();
        try {
            ITradeOrderOperation iTradeOrderOperation = session
                    .getMapper(ITradeOrderOperation.class);
            List<TradeOrder> tradeOrders = iTradeOrderOperation.getTradeOrderByBuyerID(buyer_id);
            for (TradeOrder tradeOrder : tradeOrders) {
                System.out.println(
                		tradeOrder.getOrder_id() + 
                		"buyer_id:" + tradeOrder.getBuyer_id() + 
                		"seler_id:" + tradeOrder.getSeller_id() +
                		"flow_status:" + tradeOrder.getFlow_status() +
                		"pay_status:" + tradeOrder.getPay_status() +
                		"logistics_status:" + tradeOrder.getLogistics_status() +
                		"total_qty:" + tradeOrder.getOrder_total_qty() +
                		"total_money:" + tradeOrder.getOrder_total_money() +
                		"paid_money:" + tradeOrder.getOrder_total_paid_money() +
                		"refund_id:" + tradeOrder.getOrder_refund_id() +
                		"gmt_create:" + tradeOrder.getGmt_create() + 
                		"gmt_modified:" + tradeOrder.getGmt_modified()    		
                        );
            }

        } finally {
            session.close();
        }
    }

    
    /**
     * 增加后要commit
     */
    public void addTradeOrder() {
    	TradeOrder tradeOrder = new TradeOrder();
    	tradeOrder.setOrder_id(1);
    	tradeOrder.setBuyer_id(1);
    	tradeOrder.setSeller_id(2);
        SqlSession session = wSessionFactory.openSession();
        try {
            ITradeOrderOperation iTradeOrderOperation = session
                    .getMapper(ITradeOrderOperation.class);
            iTradeOrderOperation.addTradeOrder(tradeOrder);
            session.commit();
            System.out.println("新增用户ID：" + tradeOrder.getOrder_id());
        } finally {
            session.close();
        }
    }

    /**
     * 修改后要commit
     */
    public void updateTradeOrder() {
        SqlSession session = wSessionFactory.openSession();
        try {
            ITradeOrderOperation iTradeOrderOperation = session
                    .getMapper(ITradeOrderOperation.class);
            TradeOrder tradeOrder = iTradeOrderOperation.getTradeOrderByOrderID(1);
            if (tradeOrder != null) {
            	tradeOrder.setBuyer_id(10);
            	iTradeOrderOperation.updateTradeOrder(tradeOrder);
                session.commit();
            }
        } finally {
            session.close();
        }
    }

    /**
     * 删除后要commit.
     * 
     * @param id
     */
    public void deleteTradeOrder(int order_id) {
    	SqlSession session = wSessionFactory.openSession();
        try {
        	ITradeOrderOperation iTradeOrderOperation = session
                    .getMapper(ITradeOrderOperation.class);
        	iTradeOrderOperation.deleteTradeOrder(order_id);
            session.commit();
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        try {
        	
        	TradeOrderUtil tradeOrderutil = new TradeOrderUtil();
            tradeOrderutil.init("conf.xml");
        	TradeOrder tradeOrder = new TradeOrder();
        
        			tradeOrder.setOrder_id(2);
        			tradeOrder.setBuyer_id(2);
        			tradeOrder.setSeller_id(3);
        			tradeOrder.setFlow_status("0");
        			tradeOrder.setPay_status("Success");
        			tradeOrder.setLogistics_status("0");
        			tradeOrder.setOrder_total_qty(2);
        			tradeOrder.setOrder_total_money("10000");
        			tradeOrder.setOrder_total_paid_money("2000");
        			tradeOrder.setOrder_refund_id("refund");
        			tradeOrder.setGmt_create("2016-07-10 00:00:00");
        			tradeOrder.setGmt_modified("2016-07-09 00:00:00");
            		//util.addOffer(offer);
        			tradeOrderutil.getTradeOrderByOrderID(1);
        			tradeOrderutil.getTradeOrderBuyerID("%1%");
        			//tradeOrderutil.addTradeOrder();
        			//tradeOrderutil.updateTradeOrder();
        			tradeOrderutil.deleteTradeOrder(1);   
        			 System.out.println("OK");		
        } catch (Exception e) {
        	System.out.println("haveMessage");		
            System.out.println(e.getMessage());
        }
    }

}

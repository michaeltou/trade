package com.trade.offer.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trade.offer.Offer;
import com.trade.offer.OfferUtil;

/**
 * Servlet implementation class Json
 */
public class offerJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public offerJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  PrintWriter out = 	response.getWriter();
	  
	  
	  out.println("ok");
	  System.out.println("here");
	  out.flush();
	  out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = 	response.getWriter();
		
		
	  String offer_id=	request.getParameter("offer_id");
	  String sku_id=	request.getParameter("sku_id");	  
	  String offer_name=	request.getParameter("offer_name");
	  String offer_detail=	request.getParameter("offer_detail");
	  String offer_seller_id=	request.getParameter("offer_seller_id");
	  String offer_org_price=	request.getParameter("offer_org_price");
	  String offer_pro_price=	request.getParameter("offer_pro_price");
	  String offer_qty=	request.getParameter("offer_qty"); 	
	  String offer_tag=	request.getParameter("offer_tag");
	  String offer_attribute=	request.getParameter("offer_attribute");
	  String gmt_create=	request.getParameter("gmt_create");
	  String gmt_modified=	request.getParameter("gmt_modified");
	  String offer_status=	request.getParameter("offer_status");
	  
	  //
		OfferUtil util = new OfferUtil();
		util.init("conf.xml");
	 
		//util.addOffer(offer);
		util.getOfferById(1);
	 
		Offer offer = util.getOfferById(1);
		
		  String result = null;
		  
		// result = Json.toString(offer);
		
		
	  
 
	  
 
   
 
	
	  out.println(result);
	 
	  out.flush();
	  out.close();
		
	}

}

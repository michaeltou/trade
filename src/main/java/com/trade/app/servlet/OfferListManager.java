package com.trade.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONObject;

import com.trade.infrastructure.offer.OfferOperator;
import com.trade.offer.Offer;

/**
 * Servlet implementation class LiveRoomManager
 */
public class OfferListManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Log log =LogFactory.getLog(UserQueryServlet.class);
	private static final OfferOperator offerOperator =new OfferOperator();

    /**
     * Default constructor. 
     */
    public OfferListManager() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			String roomidStr = request.getParameter("roomid");
			int roomid = Integer.parseInt(roomidStr);
			List<Offer> offerList = offerOperator.getOfferByRoomid(roomid);
			ResultModel<List<Offer>> rm = new ResultModel<List<Offer>>();
			rm.setModel(offerList);
			rm.setSuccess(true);
			String out = JSONObject.fromObject(rm).toString();
			ServletOutUtil.output(response, out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("get offerList by room_id failed,args:"+JSONObject.fromObject(request).toString(),e);

		}
	}

}

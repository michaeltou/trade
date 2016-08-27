package com.trade.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.trade.infrastructure.offer.OfferOperator;
import com.trade.offer.OfferDTO;

public class OfferDetailManager  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final OfferOperator offerOperator =new OfferOperator();
	
	

    /**
     * Default constructor. 
     */
    public OfferDetailManager() {
        // TODO Auto-generated constructor stub
    	
    }

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
			String method = request.getParameter("method");
			String offerIdStr = request.getParameter("offer_id");
			long offerId = Long.parseLong(offerIdStr);
			String picTypeStr = request.getParameter("pic_type");
			int pic_type=Integer.parseInt(picTypeStr);

		     OfferDTO offerDTO = offerOperator.getOffer(offerId,pic_type);
		     ResultModel<OfferDTO> rm = new ResultModel<OfferDTO>();
			 rm.setModel(offerDTO);
			 rm.setSuccess(true);
			 String out = JSONObject.fromObject(rm).toString();
			 ServletOutUtil.output(response, out);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ServletOutUtil.outputError(response, "1", "输出直播间list异常");
		}
	}

}

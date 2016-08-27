package com.trade.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.trade.infrastructure.address.AddressDO;
import com.trade.infrastructure.address.AddressOperator;

public class AddressQueryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	
	private static final Log log =LogFactory.getLog(UserQueryServlet.class);

	
	private static final AddressOperator addressOperator = new AddressOperator();
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
			String userIdStr = request.getParameter("user_id");
			Long userId = Long.parseLong(userIdStr);
			String addressTypeStr = request.getParameter("address_type");
			int addressType = Integer.parseInt(addressTypeStr);
			List<AddressDO> addressList = addressOperator.selectUserAddressByUserAndType(userId, addressType);
			ResultModel<List<AddressDO>> rm = new ResultModel<List<AddressDO>>();
			rm.setModel(addressList);
			rm.setSuccess(true);
			String out = JSONObject.fromObject(rm).toString();
			ServletOutUtil.output(response, out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("query user failed,args:"+JSONObject.fromObject(request).toString(),e);
		}
	}
}


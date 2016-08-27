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

import com.trade.infrastructure.liveroom.LiveRoom;
import com.trade.infrastructure.liveroom.LiveRoomOperator;

public class LiveRoomListQueryServlet extends HttpServlet{
	
	private static final Log log =LogFactory.getLog(LiveRoomListQueryServlet.class);
	private static final LiveRoomOperator liverRoomOperator = new LiveRoomOperator();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			String sizeStr = request.getParameter("count");
			int count = Integer.parseInt(sizeStr);
			List<LiveRoom> roomList = liverRoomOperator.getTopLiveRoomList(count);
			ResultModel<List<LiveRoom>> rm = new ResultModel<List<LiveRoom>>();
			rm.setModel(roomList);
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

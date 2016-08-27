package com.trade.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.chat.Message;
import com.chat.MessageUtil;
import com.trade.liveroom.LiveRoom;
import com.trade.liveroom.LiveRoomUtil;

/**
 * Servlet implementation class LiveRoomManager
 */
public class LiveRoomManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LiveRoomUtil lrUtil;

    /**
     * Default constructor. 
     */
    public LiveRoomManager() {
        // TODO Auto-generated constructor stub
    	lrUtil = new LiveRoomUtil();
		try {
			lrUtil.init("conf.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			String sizeStr = request.getParameter("size");
			int size = Integer.parseInt(sizeStr);
			List<LiveRoom> liveroomList = lrUtil.getTopLiveRoomList(size);
			ResultModel<List<LiveRoom>> rm = new ResultModel<List<LiveRoom>>();
			rm.setModel(liveroomList);
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

package com.trade.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class ServletOutUtil {

	public static void output(HttpServletResponse response, String out) throws IOException {
		PrintWriter pw = response.getWriter();
		pw.println(out);
		pw.flush();
		pw.close();
	}
	public static void outputError(HttpServletResponse response, String errorCode, String errorMsg) {
		try {
			ResultModel<String> rm = new ResultModel<String>();
			rm.setErrorCode(errorCode);
			rm.setErrorMsg(errorMsg);
			String out = JSONObject.fromObject(rm).toString();
			output(response, out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

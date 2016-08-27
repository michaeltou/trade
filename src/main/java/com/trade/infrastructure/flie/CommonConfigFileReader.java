package com.trade.infrastructure.flie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonConfigFileReader {
	
	 private static final Log log =LogFactory.getLog(CommonConfigFileReader.class);

	 public static String  readConfigFromFileWithToken(String fileName,String token) {
	        String result = null;
	        BufferedReader reader = null;
	        try {
	        	 File file = new File(fileName);
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            int line = 1;
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	            	if(tempString.contains(token)){
	            		result = tempString;
	            		break;
	            	}
	            }
	            reader.close();	            
	        } catch (IOException e) {
	            log.error("read file failed,fileName:"+fileName+";token:"+token,e);
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	            return result;
	        }
	    }
}

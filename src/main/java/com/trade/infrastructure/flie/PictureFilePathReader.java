package com.trade.infrastructure.flie;



import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.trade.infrastructure.MyBatisOperator;

public class PictureFilePathReader {
	 private static final String PICTURE_CONFIG_FILE_PATH="config/pic_config.txt";
	 private static final String PIC_ABSOLUTE_PATH="pic_path";
	 private static final char SPLICT_CHAR='`';

	 private static final Log log =LogFactory.getLog(PictureFilePathReader.class);
	 
	 
	 public static String getPicConfigPath(){
		 String path= PictureFilePathReader.class.getResource("/").getPath();
		 String configFileLocation = path+PICTURE_CONFIG_FILE_PATH;
		 String configValue =  CommonConfigFileReader.readConfigFromFileWithToken(configFileLocation, PIC_ABSOLUTE_PATH);
		 if(StringUtils.isNotBlank(configValue)){
			 int index = configValue.indexOf(SPLICT_CHAR);
			 if(index != -1){
				 return configValue.substring(index+1, configValue.length());
			 }
		 }
		 return null;
	 }
	
}

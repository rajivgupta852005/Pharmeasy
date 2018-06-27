package com.demo.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent == null)
		{	
			Date date = new Date();
			String reportName = date.toString().replace(":","_").replace(" ","_")+".html";
			//extent = new ExtentReports(System.getProperty("user.dir")+"\\reports\\"+reportName);
			extent = new ExtentReports(System.getProperty("user.dir")+"\\reports\\"+reportName,true,DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		}
		
		return extent;
	}

}

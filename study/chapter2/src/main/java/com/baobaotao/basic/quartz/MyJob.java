package com.baobaotao.basic.quartz;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

public class MyJob implements Job {

	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		Map dataMap = jctx.getJobDetail().getJobDataMap();
		String size = (String)dataMap.get("size");
		
		ApplicationContext ctx = (ApplicationContext)dataMap.get("applicationContext");
		System.out.println("size:" + size);
		dataMap.put("size", size + "0");
	}

}

package com.baobaotao.basic.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {

	public void execute(JobExecutionContext jobCtx) throws JobExecutionException {
		System.out.println(jobCtx.getTrigger().getName() + "trigger.time is:" + (new Date()));
	}

}

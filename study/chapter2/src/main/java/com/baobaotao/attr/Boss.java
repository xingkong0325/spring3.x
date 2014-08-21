package com.baobaotao.attr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.baobaotao.ditype.Car;

public class Boss {
	private Car car = new Car();
	private List favorites = new ArrayList();
	private Map jobs = new HashMap();
	private Properties mails = new Properties();
	private Map<String, Integer> jobTime = new HashMap<String, Integer>();

	public Map<String, Integer> getJobTime() {
		return jobTime;
	}

	public void setJobTime(Map<String, Integer> jobTime) {
		this.jobTime = jobTime;
	}

	public Properties getMails() {
		return mails;
	}

	public void setMails(Properties mails) {
		this.mails = mails;
	}

	public Map getJobs() {
		return jobs;
	}

	public void setJobs(Map jobs) {
		this.jobs = jobs;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List getFavorites() {
		return favorites;
	}

	public void setFavorites(List favorites) {
		this.favorites = favorites;
	}
	
}

package com.donnglin.concurrent.thread;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DelegationVehicleTracker {
	
	private final ConcurrentMap<String, Point> locations;
	private final Map<String, Point> unmodifiableMap;
	
	public DelegationVehicleTracker(Map<String, Point> points){
		locations = new ConcurrentHashMap<String, Point>(points);
		unmodifiableMap = Collections.unmodifiableMap(locations);
	}
	
	public Map<String, Point> getLocations(){
		return unmodifiableMap;
	}

	public Point getLocation(String id){
		return locations.get(id);
	}
	
	public void setLocations(String id, int x, int y){
		if(locations.replace(id, new Point(x, y)) == null){
			throw new IllegalArgumentException("invalid vehicle name: " + id);
		}
	}
}

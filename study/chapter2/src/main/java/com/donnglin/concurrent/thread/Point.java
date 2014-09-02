package com.donnglin.concurrent.thread;

import org.apache.http.annotation.Immutable;

@Immutable
public class Point {
	
	public final int x, y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}

}

package com.baobaotao;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimpleThreadLocal {
	
	private Map valueMap = Collections.synchronizedMap(new HashMap());
	
	public void set(Object newValue){
		valueMap.put(Thread.currentThread(), newValue);
	}

	public Object get(){
		Thread currentThread = Thread.currentThread();
		Object o = valueMap.get(currentThread);
		if(o == null && !valueMap.containsKey(currentThread)){
			o = initialValue();
			valueMap.put(currentThread, o);
		}
		return o;
	}

	private Object initialValue() {
		return null;
	}
	
	public void remove(){
		valueMap.remove(Thread.currentThread());
	}
}

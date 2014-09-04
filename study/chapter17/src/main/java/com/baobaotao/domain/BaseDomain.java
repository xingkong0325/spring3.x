package com.baobaotao.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5736172532717316494L;
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

}

package com.baobaotao.exception;

public class UserExistException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserExistException(String errorMsg)
    {
        super(errorMsg);
    }
}

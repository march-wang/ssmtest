package com.javen.common;

import java.io.Serializable;

import javax.faces.flow.builder.ReturnBuilder;

 

public class BaseResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2390376836163366606L;

	private boolean success;

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	private String error;

	public BaseResult(boolean success, String error) {
		this.error = error;
		this.success = success;

	}

	public BaseResult(boolean success, T data) {
		this.success = success;
		this.data = data;

	}
	
	public boolean isSuccess()
	{
		return success;
	}
	
	public void setSuccess(boolean success)
	{
		this.success = success;
		
	}
	
	
	@Override
	public String toString()
	{
		return "BaseResult [success=]" + success + ", data=" + data; 
	}
}

package com.example.demo.response;

public class Response<T> {


	
    private T data;
	private String message;
    
	public Response(T data, String message) {
		super();
		this.data = data;
		this.message = message;
	}

}

package com.prasenjit.spring;

public class HelloWorld {
	private String message;
	private String message1;
	
	public void setMessage(String message){
		this.message=message;
	}
	public void setMessage1(String message1){
		this.message1=message1;
	}
	public String getMessage(){
		return message;
	}
	public String getMessage1(){
		return message1;
	}
	public void init(){
		System.out.println("Bean going to init....");
	}
	public void destroy(){
		System.out.println("Bean going to destroy....");
	}

}

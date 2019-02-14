package com.prasenjit.constructor.chaning;

public class Demo {
public Demo(int a,int b){
	this(10.1f,100);
	System.out.println("1");
}
public Demo(float a, int b){
	this("Prasenjit");
	System.out.println("2");
}
public Demo(String a){
	System.out.println("3");
}
public Demo(){
	this(10,20);
	System.out.println("4");
}
}

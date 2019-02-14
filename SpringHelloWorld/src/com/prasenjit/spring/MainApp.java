package com.prasenjit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		//obj.setMessage("I am form Object A");
		System.out.println(("Message from HelloWorld: " + obj.getMessage()));
		HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
		System.out.println("Message from HelloWorld: " + objB.getMessage());
		((AbstractApplicationContext) context).registerShutdownHook();
		System.out.println("Message from HelloWorld: " + objB.getMessage());
		System.out.println("Message from HelloWorld: " + objB.getMessage1());
		
		HelloIndia objIndA = (HelloIndia) context.getBean("helloIndia");
		System.out.println("Message from HelloIndia: " + objIndA.getMessage());
		System.out.println("Message from HelloIndia: " + objIndA.getMessage1());
		System.out.println("Message from HelloIndia: " + objIndA.getMessage2());
		
	}
}

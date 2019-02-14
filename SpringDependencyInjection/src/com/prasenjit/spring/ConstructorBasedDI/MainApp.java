package com.prasenjit.spring.ConstructorBasedDI;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
public static void main(String[] args) {
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("CBean.xml");
	TextEditor objTe = (TextEditor) context.getBean("textEditor");
	objTe.spellCheck();
}
}

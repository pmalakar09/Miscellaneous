package com.prasenjit.spring.SetterBasedDI;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
public static void main(String[] args) {
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("SBean.xml");
	TextEditor objTe = (TextEditor) context.getBean("textEditor");
	objTe.spellCheck();
	System.out.println("OBJ: " + objTe.getSpellChecker());
}
}

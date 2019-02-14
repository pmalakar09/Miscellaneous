package com.prasenjit.spring.ConstructorBasedDI;

public class TextEditor {
	private SpellChecker spellchecker;
	
	public TextEditor(SpellChecker spellChecker){
		this.spellchecker=spellChecker;
		System.out.println("Inside TextEditor Constructor!!");
	}
	public void spellCheck(){
		spellchecker.checkSpelling();
	}

}

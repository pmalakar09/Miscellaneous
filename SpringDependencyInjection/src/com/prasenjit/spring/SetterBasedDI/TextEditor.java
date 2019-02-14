package com.prasenjit.spring.SetterBasedDI;

public class TextEditor {
	private SpellChecker spellChecker;
	
	public void setSpellChecker(SpellChecker spellChecker){
		this.spellChecker=spellChecker;
		System.out.println("Inside TextEditor Setter!!");
	}
	public SpellChecker getSpellChecker(){
		return spellChecker;
	}
	public void spellCheck(){
		spellChecker.checkSpelling();
	}

}

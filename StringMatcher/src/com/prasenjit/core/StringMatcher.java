package com.prasenjit.core;

public class StringMatcher {
	public static void main(String[] args) {
		Helper objHelper = new Helper();
		objHelper.input();
		int resultCode = objHelper.matcher();
		if (resultCode == 0) {
			System.out.println("Strings Are Not Same!");
		} else if (resultCode == 1) {
			System.out.println("Both The Strings Are Same!");
		} else if (resultCode == -1) {
			System.out.println("Inputs are Empty!!");
		}
	}
}

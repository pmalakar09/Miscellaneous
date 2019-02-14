package com.prasenjit.core;

import java.util.Scanner;

public class Helper {
	String string1, string2;
	int count;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter 1st String: ");
		string1 = sc.nextLine();
		System.out.println("Please Enter 2nd String: ");
		string2 = sc.nextLine();
		System.out.println("UniCode: " + string1.codePointAt(0));
		sc.close();
	}

	public int matcher() {
		if (string1.length() == 0 && string2.length() == 0) {
			return -1;
		} else if (string1.length() == string2.length()) {
			for (int i = 0; i < string1.length(); i++) {
				if (string1.charAt(i) == string2.charAt(i)) {
					count++;
				} else {
					count--;
				}
			}
			if (count == string1.length()) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
}

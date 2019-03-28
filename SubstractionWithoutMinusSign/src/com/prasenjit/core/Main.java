package com.prasenjit.core;

public class Main {
public static void main(String[] args) {
	int i=6,j=5,result;
//	result=i-j;
	result=i+~j+1; //Any -ve number is represented by (1's compliment + 1) of its +ve number
	System.out.println(result);
	System.out.println(~j+1);
}
}

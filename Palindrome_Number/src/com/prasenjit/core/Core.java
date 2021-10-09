package com.prasenjit.core;

public class Core {

	public static void main(String[] args) {
		int r,sum=0,temp;
		int input=1222222;
		temp=input;
		while(input>0){
			r=input%10;
			sum=(sum*10)+r;
			input=input/10;
			System.out.println("SUM: "+sum);
			System.out.println("Input"+input);
			System.out.println("/"+5%10);
		}
if(temp==sum){
	System.out.println("Palindrome Number");
}
else{
	System.out.println("Number is not Palindrome");
}
	}

}

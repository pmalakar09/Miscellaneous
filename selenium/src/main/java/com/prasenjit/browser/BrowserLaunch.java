package com.prasenjit.browser;

public class BrowserLaunch {
public static void main(String[] args) {
	System.setProperty("chromedriver", "D:\\Eclipse Workspace\\Lib\\chromedriver_win32\\chromedriver.exe");
	new ChromeDriver();
}
}

package com.prasenjit.filerename.execution;

import com.prasenjit.filerename.core.RenameFile;
import com.prasenjit.filerename.utils.Loading;

public class Execution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loading objLoading = new Loading();
		RenameFile objRenameFile = new RenameFile();
		objLoading.readInput(objRenameFile);
		boolean result = objRenameFile.rename();
		if (result == true) {
			System.out.println("All files Rename Successfully!!");
		} else {
			System.out.println("Files cannot Rename Successfully!! Some exception occures!!");

		}
	}

}

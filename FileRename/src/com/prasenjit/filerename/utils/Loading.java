package com.prasenjit.filerename.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import com.prasenjit.filerename.core.RenameFile;

public class Loading {
	public void readInput(RenameFile objrenameFile) {
		FileInputStream fileInput = null;
		try {
			File file = new File("Input.properties");
			fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			objrenameFile.setAbsolutePath(properties.getProperty("ABSOLUTE_PATH"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR during loading the Input.properties!!!! " + e);
		}

	}
}

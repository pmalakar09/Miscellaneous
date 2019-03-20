package com.prasenjit.filerename.core;

import java.io.File;

public class RenameFile {
	private String absolutePath = null;

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;

	}

	public boolean rename() {
		try {

			// change file names in 'Directory':
			File dir = new File(absolutePath);
			File[] dirInDir = dir.listFiles();
			System.out.println(dirInDir[0]);

			int i = 0, count = 0;
			for (File file : dirInDir) {
				if (dirInDir[i].isDirectory()) {
					File[] filesInDir = dirInDir[i].listFiles();
					for (File file1 : filesInDir) {
						// count++;
						String name = file1.getName();
						System.out.println("NAME::" + name);
						System.out.println(name);
						System.out.println(dirInDir[i].getName());
						String newName = dirInDir[i].getName() + ".txt";
						String newPath = dirInDir[i] + "\\" + newName;
						System.out.println(dirInDir[i]);
						System.out.println("PATH:" + newPath);
						file1.renameTo(new File(newPath));
						System.out.println(name + " changed to " + newName);
					}
					i++;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println("Exception Occure!!");
			return false;
		}
	}
}

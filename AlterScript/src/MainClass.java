import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class MainClass {

	private static final String FILENAME = "D:\\My Workspace\\Python-Workspace\\Script-Alter\\TestScript.sql";

	public static void main(String[] args) {

		BufferedWriter bw = null;
		FileWriter fw = null;
		Scanner fs=new Scanner(FILENAME);
		String currentLine =null;
		//StringBuffer sb=new StringBuffer();

		try {
			File file = new File(FILENAME);
			String sb= FileUtils.readFileToString(file, "UTF-8");
			Scanner sc=new Scanner(System.in);
			System.out.println("Please Enter The COLUMN NAME Want To Add In The VIEW : ");

			String data = sc.nextLine();

			//File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}

}
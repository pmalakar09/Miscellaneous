import java.io.*;

public class IOFile {
	public static void main(String[] args) throws Exception {
		String File1 = "D:\\Eclipse JEE Projects\\IOFile\\Input.txt";
		String File2 = "D:\\Eclipse JEE Projects\\IOFile\\Output.txt";
		try {
			FileInputStream fis = new FileInputStream(File1);
			FileOutputStream fos = new FileOutputStream(File2);
			int data;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
		} catch (Exception e) {
			System.out.println("IO exception Occur");
		}
		finally {
			System.out.println("Execution Complete");
		}

	}
}

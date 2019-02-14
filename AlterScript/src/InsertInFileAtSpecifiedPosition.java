import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class InsertInFileAtSpecifiedPosition {
  public static void main(String[] args) throws IOException {
 
      String fileName = "D:\\My Workspace\\Python-Workspace\\Script-Alter\\TestScript.sql";
      FileReader fr = new FileReader("D:\\My Workspace\\Python-Workspace\\Script-Alter\\TestScript.sql");
      BufferedReader br = new BufferedReader(fr);
 
      // 1) Read from file in String
      String str = br.readLine();
 
      // 2) Insert content at specified position in String, as per your
      // requirement
      String updatedStr = str.substring(0, 4) + "ARE " + str.substring(4);
 
      br.close();
 
      // 3) write updated String in file
      FileWriter writer = new FileWriter(fileName);
      writer.write(updatedStr);
      writer.close();
  }
}
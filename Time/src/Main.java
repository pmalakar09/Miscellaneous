import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
public static void main(String[] args) {
	String a=null, b=null;
	a=new SimpleDateFormat("HH-mm-ss.SSS").format(new Date());
	System.out.println("gap");
	b=new SimpleDateFormat("HH-mm-ss.SSS").format(new Date());
	System.out.println(a+" : "+b);
}
}

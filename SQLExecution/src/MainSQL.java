import java.sql.*;
import java.sql.Statement;
public class MainSQL {

	public static void main(String[] args) {
	
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("Driver Loading Is Done Successfully");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","admin","1989");
	System.out.println("Connection Established");
    Statement stmt=con.createStatement();
	String s="select first_name , last_name, job_id from employees where(salary>25500)";
	ResultSet res=stmt.executeQuery(s);
	System.out.println("SQL Query Executing");
	while(res.next())
	{
		String a=res.getString(1);
		String b=res.getString(2);
		String c=res.getString(3);
		System.out.println(a+" "+b+" "+c);
	}
	
	
} 


catch (Exception e) {
	
	e.printStackTrace();
}
	}

}

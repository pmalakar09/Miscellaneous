import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import oracle.jdbc.driver.OracleDriver;

public class MainSQL 
{
public static void main(String[] args) throws SQLException
	{
	Connection con = null;
	  try {
		  			DriverManager.registerDriver(new OracleDriver());
		  			System.out.println("Oracle Driver Loading Done Successfully");
		  		    con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","admin","1989");
		  		    System.out.println("DataBase Connection Is Successfully Estabilished");
		  			String s="insert into voters values(?,?,?,?,?,?,?,?,?,?)";
		  			PreparedStatement pstmt=con.prepareStatement(s);
		  			Scanner scan=new Scanner(System.in);
		  			System.out.println("Please Enter The Number Of Data Rows You Want To Insert : ");
		  			int j=scan.nextInt();
		  			con.setAutoCommit(false);
		  			for(int i=0;i<j;i++)
		  				{
		  					System.out.println("Please Enter The VOTER ID :");
		  					String s1=scan.next();
		  					System.out.println("Please Enter The VOTERS NAME :");
		  					String s2=scan.next();
		  					System.out.println("Please Enter The VOTERS FATHER NAME :");
		  					String s3=scan.next();
		  					System.out.println("Please Enter The VOTERS ADDRESS :");
		  					String s4=scan.next();
		  					System.out.println("Please Enter The VOTERS SEX :");
		  					String s5=scan.next();
		  					System.out.println("Please Enter The VOTERS DOB :");
		  					String s6=scan.next();
		  					System.out.println("Please Enter The VOTERS PANCHAYAT NO :");
		  					String s7=scan.next();
		  					System.out.println("Please Enter The VOTERS WARD NO :");
		  					String s8=scan.next();
		  					System.out.println("Please Enter The VOTERS ASSEMBLY NO :");
		  					String s9=scan.next();
		  					System.out.println("Please Enter The VOTERS PARLAMENT NO :");
		  					String s10=scan.next();
		  					pstmt.setString(1, s1);
		  					pstmt.setString(2, s2);
		  					pstmt.setString(3, s3);
		  					pstmt.setString(4, s4);
		  					pstmt.setString(5, s5);
		  					pstmt.setString(6, s6);
		  					pstmt.setString(7, s7);
		  					pstmt.setString(8, s8);
		  					pstmt.setString(9, s9);
		  					pstmt.setString(10, s10);
		  					pstmt.addBatch();
		  					con.setAutoCommit(true);
		  				}
		  			pstmt.executeBatch();
		  			System.out.println("All Rows Are Inserted Successfully");
		  		    
		  		
	  		} 
	     
	  catch (SQLException e) 
	  		{
		    System.out.println(e.getMessage());
		  	 con.rollback();
	  		}
	
	
	}
	
	
}
